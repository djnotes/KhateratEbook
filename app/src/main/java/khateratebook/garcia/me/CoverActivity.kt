package khateratebook.garcia.me

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.core.app.ActivityOptionsCompat

class CoverActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cover)
    }

    fun showTOC(view: View) {
        val intent: Intent ?= Intent(this, TOC_Activity::class.java)
        intent?.putExtra(EXTRA_MESSAGE, true)
        val sharedView : ImageView = findViewById(R.id.img_cover_id)
        startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(this, sharedView, "sharedImage").toBundle())
    }

    companion object {
        val EXTRA_MESSAGE = "mehdihaghgoo.khateratebook.OPEN_MESSAGE"
    }
}
