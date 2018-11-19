package com.IntCoreAndroidAssessment.abdo.movieapi;

import com.IntCoreAndroidAssessment.abdo.model.TopRatedMovies;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface MovieApi {

    @GET("top_rated?api_key=3c3d662f3dfecdd191da7642c1b1e2af")
    Observable<TopRatedMovies> getTopRatedMovies();

}
