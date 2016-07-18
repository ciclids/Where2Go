package com.ciclids.where2go.lib.di;

import com.ciclids.where2go.Where2goAppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by max on 2016
 */
@Singleton
@Component(modules = {LibsModule.class, Where2goAppModule.class})
public interface LibsComponent {
}
