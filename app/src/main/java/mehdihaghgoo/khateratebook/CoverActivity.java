package mehdihaghgoo.khateratebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.Button;

public class CoverActivity extends AppCompatActivity {

    Intent intent;
    public final static String EXTRA_MESSAGE="mehdihaghgoo.khateratebook.OPEN_MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cover);

        Button btnShowTOC=(Button)findViewById(R.id.btn_show_toc_id);

    }

    public void showTOC(View view) {
        intent= new Intent(CoverActivity.this,MainActivity.class);
        intent.putExtra(EXTRA_MESSAGE,true);
        startActivity(intent);
    }
}
