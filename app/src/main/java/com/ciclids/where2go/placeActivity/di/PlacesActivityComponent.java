package com.ciclids.where2go.placeActivity.di;

import com.ciclids.where2go.Where2goAppModule;
import com.ciclids.where2go.lib.di.LibsModule;
import com.ciclids.where2go.placeActivity.PlaceActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by max on 2016
 */
@Singleton
@Component(modules = {PlacesActivityModule.class, LibsModule.class, Where2goAppModule.class})
public interface PlacesActivityComponent {
    void inject(PlaceActivity activity);
}
