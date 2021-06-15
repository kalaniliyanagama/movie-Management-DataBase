package com.example.mobilecw2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterMovie extends AppCompatActivity {



        EditText movie_name, released_year, Director, casts,ratings, Review;
        Button add;

        DatabaseHelper db;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_register_movie);

            db = new DatabaseHelper(this);

            init();

            setListener();

        }

        private void setListener() {

            add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String movienameTXT = movie_name.getText().toString();
                    String releasedyearTXT= released_year.getText().toString();
                    String directorTXT = Director.getText().toString();
                    String castsTXT = casts.getText().toString();
                    String ratingsTXT = ratings.getText().toString();
                    String reviewTXT = Review.getText().toString();

                    Boolean checkinsertdata = db.insert_User_Data(movienameTXT, releasedyearTXT, directorTXT, castsTXT, ratingsTXT, reviewTXT);
                    if (checkinsertdata == true)
                        Toast.makeText(RegisterMovie.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(RegisterMovie.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();}

            });
        }


        private void init() {

            movie_name = (EditText) findViewById(R.id.moviename);
            released_year = (EditText) findViewById(R.id.movieyear);
            Director = (EditText) findViewById(R.id.moviedirector);
            casts = (EditText) findViewById(R.id.moviecast);
            ratings = (EditText) findViewById(R.id.movierating);
            Review = (EditText) findViewById(R.id.moviereview);
            add = (Button) findViewById(R.id.btn_search);

        }
    }
