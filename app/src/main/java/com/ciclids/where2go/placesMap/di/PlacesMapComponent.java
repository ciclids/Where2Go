package com.ciclids.where2go.placesMap.di;

import com.ciclids.where2go.Where2goAppModule;
import com.ciclids.where2go.lib.di.LibsModule;
import com.ciclids.where2go.placesMap.PlacesMapFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by max on 2016
 */
@Singleton
@Component(modules = {PlacesMapModule.class, LibsModule.class, Where2goAppModule.class})
public interface PlacesMapComponent {
    void inject(PlacesMapFragment fragment);
}
