package com.IntCoreAndroidAssessment.abdo.retrofitnetwork;

import android.app.Application;
import android.content.Context;

public class BaseApp extends Application {

  private static Context context;
  public static final String BASE_URL = "http://api.themoviedb.org/3/movie/";
  @Override
  public void onCreate() {
    super.onCreate();
    context = getApplicationContext();
  }

  public static Context getContext() {
    return context;
  }
}