package com.ciclids.where2go.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.RelativeLayout;

import com.ciclids.where2go.R;
import com.ciclids.where2go.main.MainActivity;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.util.Arrays;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by max on 2016
 */
public class LoginActivity extends AppCompatActivity {
    @Bind(R.id.login_button)
    LoginButton loginButton;
    @Bind(R.id.loginContainer)
    RelativeLayout loginContainer;
    private CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        if (AccessToken.getCurrentAccessToken() != null) {
            openMainScreen();
        }


        callbackManager = CallbackManager.Factory.create();
        loginButton.setPublishPermissions(Arrays.asList("publish_actions"));
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {

            @Override
            public void onSuccess(LoginResult loginResult) {
                openMainScreen();
            }

            @Override
            public void onCancel() {
                Snackbar.make(loginContainer, R.string.login_fb_error, Snackbar.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException error) {
                Log.e(error.getClass().toString(), error.getLocalizedMessage());
                Snackbar.make(loginContainer, R.string.login_fb_error, Snackbar.LENGTH_SHORT).show();


            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    private void openMainScreen() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (AccessToken.getCurrentAccessToken() != null) {
            finish();
        }
    }
}


