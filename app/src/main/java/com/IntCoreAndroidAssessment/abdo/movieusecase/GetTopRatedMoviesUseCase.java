package com.IntCoreAndroidAssessment.abdo.movieusecase;

import com.IntCoreAndroidAssessment.abdo.datastore.TopRatedMoviesDataStore;
import com.IntCoreAndroidAssessment.abdo.model.TopRatedMovies;

import io.reactivex.Observable;

public class GetTopRatedMoviesUseCase {

    TopRatedMoviesDataStore topRatedMoviesDataStore;

    public GetTopRatedMoviesUseCase() {
        topRatedMoviesDataStore = new TopRatedMoviesDataStore();
    }

    public Observable<TopRatedMovies> getTopRatedMovies() {
        return topRatedMoviesDataStore.getTopRatedMovies();
    }
}
