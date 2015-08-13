package kr.ac.todayis;

/*
1. heart
2. refresh
 */
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startActivity(new Intent(this, EmotionActivity.class));

        TextView text = (TextView)findViewById(R.id.text);

    }

    public int timeCaculate(){
        Date date = new Date();

        long currentTime = System.currentTimeMillis();

        SharedPreferences pref = getSharedPreferences("heart", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        long lastTime = pref.getLong("last", 0);
        int heart = pref.getInt("heartNum", 1);

        if(currentTime - lastTime > 86400000){
            editor.putInt("heartNum", 5);
        }
        else if((currentTime - lastTime) / 7200000 > 2){

        }
        else{

        }


        return 0;


    }

}
