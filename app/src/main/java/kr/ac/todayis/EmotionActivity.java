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

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import kr.ac.todayis.data.EmotionItem;
import kr.ac.todayis.data.EmotionAdapter;

public class EmotionActivity extends AppCompatActivity {

    ArrayList<EmotionItem> myData;
    EmotionAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emotion);

        myData = new ArrayList<EmotionItem>();

        myAdapter = new EmotionAdapter(this, R.layout.item, myData);
        ListView myList = (ListView) findViewById(R.id.listView1);
        myList.setAdapter(myAdapter);
        myList.setOnItemClickListener(mItemClickListener);

    }


    AdapterView.OnItemClickListener mItemClickListener = new AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
            // TODO Auto-generated method stub
            final int pos = position;

            new AlertDialog.Builder(EmotionActivity.this)
                    .setTitle("선택확인")
                    .setMessage("이 항목을 선택할까요?")
                    .setPositiveButton("확인", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // TODO Auto-generated method stub
                            //확인하면 서버로 전송, 액티비티 finish;
                            finish();
                        }
                    })
                    .setNegativeButton("취소", null)
                    .show();
        }
    };

}
