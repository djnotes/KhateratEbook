package khateratebook.garcia.me

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.view.View
import androidx.core.app.ActivityOptionsCompat

class TOC_Activity : AppCompatActivity() {

    internal var intent: Intent = Intent()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toc)
        intent = Intent(this, BookViewActivity::class.java)
    }

    fun showCover(view: View) {
        intent.putExtra(EXTRA_MESSAGE, R.id.btn_cover_id)
        startActivity(intent)

    }

    fun showPreface(view: View) {
        intent.putExtra(EXTRA_MESSAGE, R.id.btn_intro_id)
        this.simpleStartActivity();
        startActivity(intent)
    }

    private fun simpleStartActivity() {
        startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(this).toBundle())
    }

    fun showCh01(view: View) {
        intent.putExtra(EXTRA_MESSAGE, R.id.btn_ch01_id)
        simpleStartActivity()
    }

    fun showCh02(view: View) {
        intent.putExtra(EXTRA_MESSAGE, R.id.btn_ch02_id)
        simpleStartActivity()
    }

    fun showCh03(view: View) {
        intent.putExtra(EXTRA_MESSAGE, R.id.btn_ch03_id)
        simpleStartActivity()
    }

    fun showCh04(view: View) {
        intent.putExtra(EXTRA_MESSAGE, R.id.btn_ch04_id)
        simpleStartActivity()
    }

    fun showCh05(view: View) {
        intent.putExtra(EXTRA_MESSAGE, R.id.btn_ch05_id)
        simpleStartActivity()
    }

    fun showAboutMe(view: View) {
        intent.putExtra(EXTRA_MESSAGE, R.id.btn_about_me_id)
        simpleStartActivity()

    }

    fun showAboutApp(view: View) {
        intent.putExtra(EXTRA_MESSAGE, R.id.btn_about_app_id)
        simpleStartActivity()
    }

    companion object {
        val EXTRA_MESSAGE = "mehdihaghgoo.khateratebook.MESSAGE"
    }
}
