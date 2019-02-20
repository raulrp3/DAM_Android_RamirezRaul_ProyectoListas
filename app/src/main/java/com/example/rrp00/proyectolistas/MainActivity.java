package com.example.rrp00.proyectolistas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listPlaces;
    Button btnNext;
    ArrayList<Place> places;
    ArrayAdapter<Place> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SaveActivity.class);
                startActivityForResult(intent,Utils.CODE_SAVE);
            }
        });

        listPlaces.setAdapter(mAdapter);
    }

    private void initUI(){
        listPlaces = findViewById(R.id.list_places);
        btnNext = findViewById(R.id.next_btn);
        places = new ArrayList<>();
        mAdapter = new PlaceAdapter(this,places);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        if (requestCode == Utils.CODE_SAVE){
            String place = data.getStringExtra("PLACE");
            places.add(new Place(place));
            mAdapter.notifyDataSetChanged();
        }
    }
}
