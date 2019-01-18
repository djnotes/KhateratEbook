package mehdihaghgoo.khateratebook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class CoverActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cover)
    }

    fun showTOC(view: View) {
        val intent: Intent ?= Intent(this, TOC_Activity::class.java)
        intent?.putExtra(EXTRA_MESSAGE, true)
        startActivity(intent)
    }

    companion object {
        val EXTRA_MESSAGE = "mehdihaghgoo.khateratebook.OPEN_MESSAGE"
    }
}
