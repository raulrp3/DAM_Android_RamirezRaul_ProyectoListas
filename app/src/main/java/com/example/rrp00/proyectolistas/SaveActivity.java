package com.example.rrp00.proyectolistas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SaveActivity extends AppCompatActivity {
    EditText etPlace;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);

        initUI();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String place = etPlace.getText().toString().trim();
                if (validate(place)){
                    Intent intent = new Intent();
                    intent.putExtra("PLACE",place);
                    setResult(Utils.CODE_SAVE,intent);
                    finish();
                }else{
                    Toast.makeText(getApplicationContext(),"¡ERROR!No puedes guardar un lugar vacío",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initUI(){
        etPlace = findViewById(R.id.place_et);
        btnSave = findViewById(R.id.save_btn);
    }

    private boolean validate(String place){
        boolean isValid = true;
        if (place.isEmpty()){
            isValid = false;
        }
        return isValid;
    }
}
