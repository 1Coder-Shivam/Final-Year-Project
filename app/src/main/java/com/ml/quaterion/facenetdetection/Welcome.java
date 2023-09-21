package com.ml.quaterion.facenetdetection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Welcome extends AppCompatActivity {

    Button ClassA,ClassB,ClassC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ClassA= findViewById(R.id.cl1);
        ClassB= findViewById(R.id.cl2);
        ClassC= findViewById(R.id.cl3);
        ClassA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAttendence("Class_A");
            }
        });
        ClassB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAttendence("Class_B");
            }
        });
        ClassC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAttendence("Class_C");
            }
        });
    }

   private void startAttendence( String nameOfClass){
       Intent i=new Intent(Welcome.this,MainActivity.class);
       i.putExtra("key",nameOfClass);
       startActivity(i);
    }
}