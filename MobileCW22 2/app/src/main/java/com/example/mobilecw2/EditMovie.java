package com.example.mobilecw2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditMovie extends AppCompatActivity {
    EditText Movie_Name, Released_Year, Director, Casts,ratings,review, ID;
    Button edit;

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_movie);

        db = new DatabaseHelper(this);

        init();

        setListener();

    }

    private void setListener() {

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String idTXT = ID.getText().toString();
                String movienameTXT = Movie_Name.getText().toString();
                String releasedyearTXT = Released_Year.getText().toString();
                String directorTXT = Director.getText().toString();
                String castsTXT = Casts.getText().toString();
                String ratingsTXT = ratings.getText().toString();
                String reviewTXT = review.getText().toString();

                Boolean checkupdatedata = db.update_Data(idTXT,movienameTXT, releasedyearTXT, directorTXT, castsTXT, ratingsTXT, reviewTXT);
                if (checkupdatedata == true)
                    Toast.makeText(EditMovie.this, "New Entry Updated", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(EditMovie.this, "New Entry Not Updated", Toast.LENGTH_SHORT).show();}

        });
    }


    private void init() {
        ID = (EditText) findViewById(R.id.id);
        Movie_Name = (EditText) findViewById(R.id.moviename);
        Released_Year = (EditText) findViewById(R.id.movieyear);
        Director = (EditText) findViewById(R.id.moviedirector);
        Casts = (EditText) findViewById(R.id.moviecast);
        ratings = (EditText) findViewById(R.id.movierating);
        review = (EditText) findViewById(R.id.moviereview);
        edit = (Button) findViewById(R.id.btn_search);

    }
}