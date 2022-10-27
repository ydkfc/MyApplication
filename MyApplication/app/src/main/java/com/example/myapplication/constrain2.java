package com.example.myapplication;


import android.app.Activity;
import android.content.Intent;
import android.view.View;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class constrain2 extends Activity {
    Button button = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.constrain2);

        button = (Button)findViewById(R.id.btn_three);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(constrain2.this,constrain1.class);
                startActivity(intent);
            }
        });
    }

}
