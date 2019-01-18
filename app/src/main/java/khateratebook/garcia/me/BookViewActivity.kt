package khateratebook.garcia.me

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle

import android.util.Log
import android.view.View
import android.webkit.WebView
import android.widget.ProgressBar


import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset

class BookViewActivity : AppCompatActivity() {

    @SuppressLint("InlinedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bookview)
        val progressBar: ProgressBar = findViewById(R.id.progressBar)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        val mWebView = findViewById<View>(R.id.webview_id) as WebView
        val mWebSettings = mWebView.settings
        mWebSettings.defaultTextEncodingName = "utf-8"

        val intent = getIntent()
        val receivedView = intent.extras?.getInt(TOC_Activity.EXTRA_MESSAGE)
        var inputStream: InputStream = resources.openRawResource(R.raw.cover)
        when (receivedView) {
            R.id.btn_cover_id -> inputStream = resources.openRawResource(R.raw.cover)
            R.id.btn_intro_id -> inputStream = resources.openRawResource(R.raw.intro)
            R.id.btn_ch01_id -> inputStream = resources.openRawResource(R.raw.ch01)
            R.id.btn_ch02_id -> inputStream = resources.openRawResource(R.raw.ch02)
            R.id.btn_ch03_id -> inputStream = resources.openRawResource(R.raw.ch03)
            R.id.btn_ch04_id -> inputStream = resources.openRawResource(R.raw.ch04)
            R.id.btn_ch05_id -> inputStream = resources.openRawResource(R.raw.ch05)
            R.id.btn_about_me_id -> inputStream = resources.openRawResource(R.raw.about_me)
            R.id.btn_about_app_id -> inputStream = resources.openRawResource(R.raw.about_app)
        }

        val buffer = ByteArray(1000000)
        var read = 0
        var allString = ""

        //Show a progress bar
        progressBar.visibility = View.VISIBLE;

        try {
            read = inputStream.read(buffer)
            val stringPart = String(buffer, Charset.forName("UTF-8"))
            allString = allString + stringPart
            Log.d(TAG, "onCreate: read length: $read")
        } catch (ex: Exception) {
            Log.e("BookViewActivity", "Error reading byte buffer to string: " + ex.toString())
        }
        progressBar.visibility = View.GONE


        //close the stream
        try {
            inputStream.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }

        Log.i("BookViewActivity", "onCreate: book string: $allString")
        val head = "<!DOCTYPE html><html><head><style> @font-face{font-family: IRANSans; src: url('file:///android_asset/fonts/IRANSans.ttf');} *{font-family:IRANSans; direction:rtl;}</style></head><body>"
        val tail = "</body></html>"
        mWebView.loadDataWithBaseURL(null, head + allString + tail, "text/html", "charset=utf-8", null)
    }

    companion object {
        private val TAG = "BookViewActivity"
    }
}
