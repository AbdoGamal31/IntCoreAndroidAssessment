package com.IntCoreAndroidAssessment.abdo.retrofitnetwork.component;

import android.content.Context;

import com.IntCoreAndroidAssessment.abdo.datastore.TopRatedMoviesDataStore;
import com.IntCoreAndroidAssessment.abdo.retrofitnetwork.BaseApp;
import com.IntCoreAndroidAssessment.abdo.retrofitnetwork.module.ApplicationModule;
import com.IntCoreAndroidAssessment.abdo.retrofitnetwork.module.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

import static com.IntCoreAndroidAssessment.abdo.retrofitnetwork.BaseApp.BASE_URL;

@Singleton
@Component(modules = {ApplicationModule.class, NetworkModule.class})
public interface NetworkComponent {

    void inject(TopRatedMoviesDataStore topRatedMoviesDataStore);

    class Initializer {

        private static NetworkComponent component;

        public static NetworkComponent buildComponent() {
            if (component == null) {
                Context context = BaseApp.getContext();
                component = DaggerNetworkComponent.builder()
                        .applicationModule(new ApplicationModule(context))
                        .networkModule(new NetworkModule(BASE_URL))
                        .build();
            }
            return component;
        }
    }
}