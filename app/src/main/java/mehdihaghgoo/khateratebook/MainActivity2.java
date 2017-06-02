package mehdihaghgoo.khateratebook;

import android.annotation.TargetApi;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

public class MainActivity2 extends AppCompatActivity {
    Button mButtonCover;
    WebView mWebView;
    InputStream inputStream;
    WebSettings mWebSettings;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mWebView = (WebView) findViewById(R.id.webview_id);
        mWebSettings = mWebView.getSettings();
        mWebSettings.setDefaultTextEncodingName("utf-8");

        intent=getIntent();
        int receivedView=intent.getExtras().getInt(MainActivity.EXTRA_MESSAGE);
//        mButtonCover = (AppCompatButton) findViewById(receivedView);
        switch(receivedView){
            case R.id.btn_cover_id:
                inputStream = getResources().openRawResource(R.raw.cover);
                break;
            case R.id.btn_intro_id:
                inputStream = getResources().openRawResource(R.raw.intro);
                break;
            case R.id.btn_ch01_id:
                inputStream=getResources().openRawResource(R.raw.ch01);
                break;
            case R.id.btn_ch02_id:
                inputStream=getResources().openRawResource(R.raw.ch02);
                break;
            case R.id.btn_ch03_id:
                inputStream=getResources().openRawResource(R.raw.ch03);
                break;
            case R.id.btn_ch04_id:
                inputStream=getResources().openRawResource(R.raw.ch04);
                break;
            case R.id.btn_ch05_id:
                inputStream=getResources().openRawResource(R.raw.ch05);
                break;
            case R.id.btn_about_me_id:
                inputStream=getResources().openRawResource(R.raw.about_me);
                break;
            case R.id.btn_about_app_id:
                inputStream=getResources().openRawResource(R.raw.about_app);
                break;
        }

        StringWriter writer = new StringWriter();
        try {
            IOUtils.copy(inputStream, writer, "UTF-8");
        } catch (IOException ioex) {
            System.out.println(ioex.getStackTrace());

        }
        //close the stream
        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String theString = writer.toString();
//        mWebView.loadDataWithBaseURL(null, theString, "text/plain", "charset=utf-8",null);
        mWebView.loadDataWithBaseURL(null,theString,"text/plain","charset=utf-8",null);
    }
}
