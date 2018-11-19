package com.IntCoreAndroidAssessment.abdo.movieviews;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.IntCoreAndroidAssessment.abdo.R;
import com.IntCoreAndroidAssessment.abdo.model.Movie;
import com.IntCoreAndroidAssessment.abdo.moviepresnter.TopRatedMoviesPresenter;

import java.util.List;

public class MovieListActivity extends AppCompatActivity implements MovieListView {

    private TopRatedMoviesPresenter topRatedMoviesPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);
        topRatedMoviesPresenter=new TopRatedMoviesPresenter(this);
        topRatedMoviesPresenter.getTopRatedMovies();
    }

    @Override
    public void showLoadingIndicator() {

    }

    @Override
    public void hideLoadingIndicator() {

    }

    @Override
    public void displayListOfTopRatedMovies(List<Movie> moviesList) {
        Log.d("displayListOf ", moviesList.size() + "");
    }
}
