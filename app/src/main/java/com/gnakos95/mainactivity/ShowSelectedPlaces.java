package com.gnakos95.mainactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;


import com.squareup.picasso.Picasso;

public class ShowSelectedPlaces extends AppCompatActivity {

    int[] flag = new int[5];
    LinearLayout mparent;
    LayoutInflater layoutInflater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ImageView imagefromurl;

        super.onCreate(savedInstanceState);
        Bundle myBundle = getIntent().getExtras();
        flag = myBundle.getIntArray("flag");
        setContentView(R.layout.activity_show_selected_places);
        mparent = findViewById(R.id.mparent);
        layoutInflater= (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
        View myView = layoutInflater.inflate(R.layout.konitsalayout,null,false);
        View myView2 = layoutInflater.inflate(R.layout.vikoslayout,null,false);
        View myView3 = layoutInflater.inflate(R.layout.zagorilayout,null,false);
        View myView4 = layoutInflater.inflate(R.layout.molivdoslayout,null,false);
        View myView5 = layoutInflater.inflate(R.layout.papigolayout,null,false);
        View myView6 = layoutInflater.inflate(R.layout.konitsalayouteng,null,false);
        View myView7 = layoutInflater.inflate(R.layout.vikoslayouteng,null,false);
        View myView8 = layoutInflater.inflate(R.layout.zagorilayouteng,null,false);
        View myView9 = layoutInflater.inflate(R.layout.molivdoslayouteng,null,false);
        View myView10 = layoutInflater.inflate(R.layout.papigolayouteng,null,false);
        Button playButton = (Button) findViewById(R.id.button3);

        if(flag[5]==9) {
            if (flag[4] == 1) {
                mparent.addView(myView);
                playButton.setVisibility(View.VISIBLE);
                playButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                            Intent startNewActivity = new Intent(ShowSelectedPlaces.this, VideoActivity.class);
                            startActivity(startNewActivity);
                    }
                });
            }
            if (flag[3] == 1) {
                mparent.addView(myView2);
            }
            if (flag[2] == 1) {
                mparent.addView(myView3);
            }
            if (flag[1] == 1) {
                mparent.addView(myView4);
            }
            if (flag[0] == 1) {
                mparent.addView(myView5);
            }
        }else{
            if(flag[4]==1){
                mparent.addView(myView6);
            }
            if(flag[3]==1){
                mparent.addView(myView7);
            }
            if (flag[2] == 1) {
                mparent.addView(myView8);
            }

            if (flag[1] == 1) {
                mparent.addView(myView9);
            }

            if (flag[0] == 1) {
                mparent.addView(myView10);
            }
        }
    }
}
