package com.example.mobilecw2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


        Button register;
        Button display;
        Button search;
        Button edit;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            register =findViewById(R.id.button_register);
            register.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(MainActivity.this,RegisterMovie.class);
                    startActivity(intent);

                }
            });

            display =findViewById(R.id.button_display);
            display.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(MainActivity.this,DisplayMovie.class);
                    startActivity(intent);

                }
            });
            search =findViewById(R.id.button_search);
            search.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(MainActivity.this,SearchMovie.class);
                    startActivity(intent);

                }
            });
            edit =findViewById(R.id.button_edit);
            edit.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(MainActivity.this,EditMovie.class);
                    startActivity(intent);

                }
            });
        }


    }
