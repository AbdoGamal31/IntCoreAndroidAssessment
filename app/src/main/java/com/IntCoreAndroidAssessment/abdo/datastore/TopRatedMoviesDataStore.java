package com.IntCoreAndroidAssessment.abdo.datastore;

import com.IntCoreAndroidAssessment.abdo.model.TopRatedMovies;
import com.IntCoreAndroidAssessment.abdo.movieapi.MovieApi;
import com.IntCoreAndroidAssessment.abdo.retrofitnetwork.component.NetworkComponent;

import javax.inject.Inject;

import io.reactivex.Observable;
import retrofit2.Retrofit;

public class TopRatedMoviesDataStore {

    @Inject
    Retrofit retrofit;
    MovieApi movieApi;

    public TopRatedMoviesDataStore() {
        NetworkComponent.Initializer.buildComponent().inject(this);
        movieApi = retrofit.create(MovieApi.class);
    }

    public Observable<TopRatedMovies> getTopRatedMovies() {
        return movieApi.getTopRatedMovies();
    }
}
