package com.example.mobilecw2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DisplayMovie extends AppCompatActivity {
    Button view;
    DatabaseHelper myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_movie);
        view=findViewById(R.id.buttonview);
        myDb = new DatabaseHelper(this);

        view.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.getAll_Data();
                        if(res.getCount() == 0) {
                            // show message for error
                            showMessage("Error","sorry not found related ");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append(" "+"\n");
                            buffer.append("Id :"+ res.getString(0)+"\n");
                            buffer.append("MovieName :"+ res.getString(1)+"\n");
                            buffer.append("ReleasedYear :"+ res.getString(2)+"\n");
                            buffer.append("Director :"+ res.getString(3)+"\n");
                            buffer.append("Casts :"+ res.getString(4)+"\n");
                            buffer.append("Ratings :"+ res.getString(5)+"\n ");
                            buffer.append("Review :"+ res.getString(6)+"\n");
                        }

                        // Show all data
                        showMessage("Data",buffer.toString());
                    }
                }
        );
    }

    public void showMessage(String title,String Message){
        android.app.AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}