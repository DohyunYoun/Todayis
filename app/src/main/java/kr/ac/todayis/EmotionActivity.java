package kr.ac.todayis;

/*
**listView
* img + text
* when clicked go to alert dialog
* ok : send to server(type, num)
*       type: which number jisu is.(1~5)
*       num: which motion jisu is.(01~15)
* cancel : dismiss
 */
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class EmotionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emotion);
    }
}
