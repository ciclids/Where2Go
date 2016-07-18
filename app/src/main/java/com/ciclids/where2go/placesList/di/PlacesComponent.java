package com.ciclids.where2go.placesList.di;

import com.ciclids.where2go.Where2goAppModule;
import com.ciclids.where2go.lib.di.LibsModule;
import com.ciclids.where2go.placesList.ui.PlacesFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by max on 2016
 */
@Singleton
@Component(modules = {PlacesModule.class, LibsModule.class, Where2goAppModule.class})
public interface PlacesComponent {
    void inject(PlacesFragment fragment);
}
