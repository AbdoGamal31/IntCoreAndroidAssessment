package com.IntCoreAndroidAssessment.abdo.retrofitnetwork;

import okhttp3.Interceptor;

import static com.IntCoreAndroidAssessment.abdo.retrofitnetwork.NetworkUtilities.isNetworkAvailable;

public class CheckConnectionInterceptor {

    public static final Interceptor CHECK_NETWORK_CONNECTION_INTERCEPTOR = chain -> {
        Boolean isConnected = isNetworkAvailable(BaseApp.getContext());
        if (!isConnected) {
            throw NetworkError.createOfflineError();
        } else {
            return chain.proceed(chain.request());
        }
    };
}
