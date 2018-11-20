package com.IntCoreAndroidAssessment.abdo.moviepresnter;

import com.IntCoreAndroidAssessment.abdo.movieusecase.GetTopRatedMoviesUseCase;
import com.IntCoreAndroidAssessment.abdo.movieviews.MovieListView;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class TopRatedMoviesPresenter {

    MovieListView movieListView;
    GetTopRatedMoviesUseCase getTopRatedMoviesUseCase;

    public TopRatedMoviesPresenter(MovieListView movieListView) {
        this.movieListView = movieListView;
        getTopRatedMoviesUseCase = new GetTopRatedMoviesUseCase();
    }

    public void getTopRatedMovies() {
        movieListView.showLoadingIndicator();
        getTopRatedMoviesUseCase.getTopRatedMovies()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(topRatedMovies -> {
                    movieListView.hideLoadingIndicator();
                    movieListView.displayListOfTopRatedMovies(topRatedMovies.getMovies());
                }, throwable -> {
                    movieListView.hideLoadingIndicator();
                });
    }
}
