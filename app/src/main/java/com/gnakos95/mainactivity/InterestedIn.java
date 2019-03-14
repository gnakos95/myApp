package com.gnakos95.mainactivity;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Toast;

import java.util.ArrayList;

public class InterestedIn extends ListActivity {

    String list[];
    private ArrayAdapter mAdapter;
    ArrayList<Integer> selectedPositions = new ArrayList<>();
    ArrayList<String> selectedItems = new ArrayList<>();
    ListView listview;
    public Button selectALl;
    int flag1=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interested_in);
        selectedPositions.add(9);
    list= getResources().getStringArray(R.array.interests);
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(InterestedIn.this,android.R.layout.simple_list_item_multiple_choice, list){
        public View getView(int position, View convertView, ViewGroup parent){
            // Get the current item from ListView
            View view = super.getView(position,convertView,parent);

            // Get the Layout Parameters for ListView Current Item View
            
            LayoutParams params = view.getLayoutParams();

            // Set the height of the Item View
            params.height = 180;
            view.setLayoutParams(params);

            return view;
        }
    };
    setListAdapter(adapter);
    listview = getListView();
    listview.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

    listview.setOnItemClickListener(new OnItemClickListener(){
        public void onItemClick(AdapterView<?> parent, View view, int position, long id){
            if(selectedPositions.contains(position)){
                selectedPositions.remove(Integer.valueOf(position));
            }else {
                selectedPositions.add(position);
            }

            if(selectedPositions.size()==7){
                selectALl.setText("Αναιρεση ολων");
                flag1=1;
            }
        }
    });

    init();
    init2();
    }

    public Button show;
    public void init() {
        show = (Button) findViewById(R.id.button2);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(selectedPositions.size()==1){
                    Toast.makeText(InterestedIn.this,
                            "Πρέπει να επιλέξεις τουλάχιστον ένα",Toast.LENGTH_LONG).show();

                }else {
                    Intent startNewActivity = new Intent(InterestedIn.this, MapsActivity.class);
                    startNewActivity.putExtra("selectedPositions", selectedPositions);
                    startActivity(startNewActivity);
                }

            }
        });
    }


    public void init2(){
        selectALl = (Button)findViewById(R.id.selectAll);

        selectALl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag1==0) {
                    for (int i = 0; i < list.length; i++) {
                        listview.setItemChecked(i, true);
                        if(!selectedPositions.contains(i)) {
                            selectedPositions.add(i);
                        }
                        flag1 = 1;
                    }

                    selectALl.setText("Αναιρεση ολων");

                }else{
                    for(int i =0; i<list.length; i++){

                        listview.setItemChecked(i,false);
                        if(selectedPositions.contains(i)){
                            selectedPositions.remove(Integer.valueOf(i));
                        }
                        flag1=0;
                    }
                    selectALl.setText("Επιλογη ολων");
                }
            }
        });

    }

}
