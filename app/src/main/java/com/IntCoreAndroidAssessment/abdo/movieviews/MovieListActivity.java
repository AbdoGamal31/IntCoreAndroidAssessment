package com.IntCoreAndroidAssessment.abdo.movieviews;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.IntCoreAndroidAssessment.abdo.R;
import com.IntCoreAndroidAssessment.abdo.model.Movie;
import com.IntCoreAndroidAssessment.abdo.moviepresnter.TopRatedMoviesPresenter;
import com.IntCoreAndroidAssessment.abdo.movieviews.adapter.TopRatedMovieListAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieListActivity extends AppCompatActivity implements MovieListView {

    private TopRatedMoviesPresenter topRatedMoviesPresenter;
    private TopRatedMovieListAdapter topRatedMovieListAdapter;
    private ProgressDialog loadingInductor;
    @BindView(R.id.top_rated_movies)
    RecyclerView topRatedMoviesRecView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);
        topRatedMoviesPresenter = new TopRatedMoviesPresenter(this);
        topRatedMovieListAdapter = new TopRatedMovieListAdapter();
        loadingInductor = new ProgressDialog(this);
        ButterKnife.bind(this);
        topRatedMoviesRecView.setLayoutManager(new LinearLayoutManager(this));
        topRatedMoviesPresenter.getTopRatedMovies();
    }

    @Override
    public void showLoadingIndicator() {
        loadingInductor.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        loadingInductor.setCancelable(false);
        loadingInductor.show();
    }

    @Override
    public void hideLoadingIndicator() {
        if (loadingInductor.isShowing())
            loadingInductor.hide();
    }

    @Override
    public void displayListOfTopRatedMovies(List<Movie> moviesList) {
        topRatedMovieListAdapter.setTopRatedMovieList(moviesList);
        topRatedMoviesRecView.setAdapter(topRatedMovieListAdapter);
    }
}
