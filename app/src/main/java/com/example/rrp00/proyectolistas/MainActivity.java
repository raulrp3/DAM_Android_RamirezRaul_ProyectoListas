package com.example.rrp00.proyectolistas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listPlaces;
    Button btnNext;
    private final int CODE_SAVE = 1;
    ArrayList<String> places;
    ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SaveActivity.class);
                startActivityForResult(intent,CODE_SAVE);
            }
        });
    }

    private void initUI(){
        listPlaces = findViewById(R.id.list_places);
        btnNext = findViewById(R.id.next_btn);
        places = new ArrayList<>();
        mAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,places);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        if (requestCode == CODE_SAVE){
            String place = data.getStringExtra("PLACE");
            places.add(place);
            listPlaces.setAdapter(mAdapter);
        }
    }
}
