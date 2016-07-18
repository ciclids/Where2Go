package com.ciclids.where2go.lib.di;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.ciclids.where2go.lib.EvntBus;
import com.ciclids.where2go.lib.GlideImageLoader;
import com.ciclids.where2go.lib.GreenRobotEventBus;
import com.ciclids.where2go.lib.ImageLoader;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class LibsModule {
    private Fragment fragment;
    private Activity activity;

    public LibsModule(Fragment fragment) {
        this.fragment = fragment;
    }

    public LibsModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @Singleton
    EvntBus provideEventBus() {
        return new GreenRobotEventBus();
    }

    @Provides
    @Singleton
    ImageLoader provideImageLoader(Fragment fragment) {

        return new GlideImageLoader(fragment);
    }

    @Provides
    @Singleton
    Fragment providesFragment() {

        return this.fragment;
    }

    @Provides
    @Singleton
    Activity providesActivity() {

        return this.activity;
    }
}
