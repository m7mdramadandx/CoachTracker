package com.tassioauad.pedometro.dagger;

import com.tassioauad.pedometro.model.api.ActivityRecognizer;
import com.tassioauad.pedometro.model.api.LocationCapturer;
import com.tassioauad.pedometro.model.dao.ActivityLocationDao;
import com.tassioauad.pedometro.presenter.HomePresenter;
import com.tassioauad.pedometro.view.HomeView;
import com.tassioauad.pedometro.view.activity.HomeActivity;

import dagger.Module;
import dagger.Provides;

@Module(library = true, includes = {AppModule.class, ApiModule.class, DaoModule.class}, injects = HomeActivity.class)
public class HomeViewModule {

    private HomeView view;

    public HomeViewModule(HomeView view) {
        this.view = view;
    }

    @Provides
    public HomePresenter provideHomePresenter(ActivityRecognizer activityRecognizer, LocationCapturer locationCapturer, ActivityLocationDao activityLocationDao) {
        return new HomePresenter(view, locationCapturer, activityRecognizer, activityLocationDao);
    }
}
