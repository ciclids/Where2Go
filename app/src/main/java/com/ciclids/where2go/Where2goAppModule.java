package com.ciclids.where2go;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by max on 2016
 */
@Module
public class Where2goAppModule {
    Context context;

    public Where2goAppModule(Context context) {

        this.context = context;
    }


    @Provides
    @Singleton
    Context provideContext() {
        return this.context;
    }
}

