package com.IntCoreAndroidAssessment.abdo.movieviews;

import com.IntCoreAndroidAssessment.abdo.model.Movie;

import java.util.List;

public interface MovieListView {

    void showLoadingIndicator();

    void hideLoadingIndicator();

    void displayListOfTopRatedMovies(List<Movie> moviesList);
}
