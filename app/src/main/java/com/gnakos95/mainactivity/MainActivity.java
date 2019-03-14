package com.gnakos95.mainactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    public Button begin;
    public Button changeLang;
    private int flag =0;
    public void init() {
        begin= (Button)findViewById(R.id.button);

        begin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag==0) {
                    Intent startNewActivity = new Intent(MainActivity.this,
                            InterestedIn.class);
                    startActivity(startNewActivity);
                }else {
                    Intent startNewActivity = new Intent(MainActivity.this,
                            InterestedInEng.class);
                    startActivity(startNewActivity);
                }
            }
        });

        changeLang = (Button)findViewById(R.id.lang);
        changeLang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag==0) {
                    tv = (TextView) findViewById(R.id.textView);
                    tv.setText(R.string.txt2);
                    changeLang.setText("GR");
                    begin.setText("Begin the sightseeing");
                    flag =1;
                }else{
                    tv = (TextView) findViewById(R.id.textView);
                    changeLang.setText("ENG");
                    tv.setText(R.string.txt);
                    begin.setText("ξεκινηστε την περιηγηση");
                    flag=0;
                }
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        init();
    }


}
