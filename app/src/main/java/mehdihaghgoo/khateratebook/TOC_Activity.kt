package mehdihaghgoo.khateratebook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.view.View

class TOC_Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent = Intent(this, BookViewActivity::class.java)
    }

    fun showCover(view: View) {
        intent?.putExtra(EXTRA_MESSAGE, R.id.btn_cover_id)
        startActivity(intent)

    }

    fun showPreface(view: View) {
        intent?.putExtra(EXTRA_MESSAGE, R.id.btn_intro_id)
        startActivity(intent)
    }

    fun showCh01(view: View) {
        intent?.putExtra(EXTRA_MESSAGE, R.id.btn_ch01_id)
        startActivity(intent)
    }

    fun showCh02(view: View) {
        intent?.putExtra(EXTRA_MESSAGE, R.id.btn_ch02_id)
        startActivity(intent)
    }

    fun showCh03(view: View) {
        intent?.putExtra(EXTRA_MESSAGE, R.id.btn_ch03_id)
        startActivity(intent)
    }

    fun showCh04(view: View) {
        intent?.putExtra(EXTRA_MESSAGE, R.id.btn_ch04_id)
        startActivity(intent)
    }

    fun showCh05(view: View) {
        intent?.putExtra(EXTRA_MESSAGE, R.id.btn_ch05_id)
        startActivity(intent)
    }

    fun showAboutMe(view: View) {
        intent?.putExtra(EXTRA_MESSAGE, R.id.btn_about_me_id)
        startActivity(intent)

    }

    fun showAboutApp(view: View) {
        intent?.putExtra(EXTRA_MESSAGE, R.id.btn_about_app_id)
        startActivity(intent)
    }

    companion object {
        val EXTRA_MESSAGE = "mehdihaghgoo.khateratebook.MESSAGE"
    }
}
