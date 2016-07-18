package com.ciclids.where2go.placeActivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.ciclids.where2go.R;
import com.ciclids.where2go.Where2goAppModule;
import com.ciclids.where2go.lib.EvntBus;
import com.ciclids.where2go.lib.di.LibsModule;
import com.ciclids.where2go.placeActivity.di.DaggerPlacesActivityComponent;
import com.ciclids.where2go.placeActivity.di.PlacesActivityModule;
import com.ciclids.where2go.placesList.events.PlacesEvent;

import org.greenrobot.eventbus.Subscribe;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class PlaceActivity extends AppCompatActivity {

    @Bind(R.id.webView)
    WebView webView;
    private String myId;
    @Inject
    EvntBus evntBus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);
        ButterKnife.bind(this);
        evntBus.register(this);
        setupInjection();


    }

    private void setupInjection() {
        DaggerPlacesActivityComponent
                .builder()
                .libsModule(new LibsModule(this))
                .placesActivityModule(new PlacesActivityModule(this))
                .where2goAppModule(new Where2goAppModule(this))
                .build()
                .inject(this);
    }


    @Subscribe
    public void onEventMainThread(PlacesEvent event) {
        if (event.getType() == event.TYPE_UNIQUE) {
            if (event.getPlace() != null) {
                myId = event.getPlace().getId();
                webView.loadUrl("https://es.foursquare.com/v/" + myId);
            }
        }
    }

}
