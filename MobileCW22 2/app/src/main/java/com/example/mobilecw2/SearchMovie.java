package com.example.mobilecw2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SearchMovie extends AppCompatActivity {

        Button search;
        EditText id;
        DatabaseHelper myDb;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_search_movie);
            search =findViewById(R.id.btn_search);
            id=findViewById(R.id.id);
            myDb = new DatabaseHelper(this);

            search.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String idTXT = id.getText().toString();
                            Cursor cursor = myDb.fetch_Data(idTXT);
                            if(cursor.getCount() == 0) {
                                // show message for errors
                                show_Message("Error","Sorry not found any related ");
                                return;
                            }

                            StringBuffer buffer = new StringBuffer();
                            while (cursor.moveToNext()) {
                                buffer.append(" "+"\n");
                                buffer.append("Id :"+ cursor.getString(0)+"\n");
                                buffer.append("Movie_Name :"+ cursor.getString(1)+"\n");
                                buffer.append("Released_Year :"+ cursor.getString(2)+"\n");
                                buffer.append("Director :"+ cursor.getString(3)+"\n");
                                buffer.append("Casts :"+ cursor.getString(4)+"\n");
                                buffer.append("Ratings :"+ cursor.getString(5)+"\n ");
                                buffer.append("Review :"+ cursor.getString(6)+"\n");
                            }

                            // Show all data
                            show_Message("Data",buffer.toString());


                        }
                    }
            );
        }

        public void show_Message(String title, String Message){
            android.app.AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setCancelable(true);
            builder.setTitle(title);
            builder.setMessage(Message);
            builder.show();
        }

    }
