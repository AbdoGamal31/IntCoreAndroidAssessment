package com.IntCoreAndroidAssessment.abdo.movieviews;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.IntCoreAndroidAssessment.abdo.R;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FacebookLogin extends AppCompatActivity {

    private static final String EMAIL = "email";
    private CallbackManager callbackManager;
    @BindView(R.id.login_button)
    LoginButton loginButton;
    AccessToken token;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook_login);
        callbackManager = CallbackManager.Factory.create();
        ButterKnife.bind(this);
        loginButton.setReadPermissions(Arrays.asList(EMAIL));

        token = AccessToken.getCurrentAccessToken();

        if (token != null) {
            startActivity(new Intent(FacebookLogin.this, MovieListActivity.class));
            finish();
        }
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                startActivity(new Intent(FacebookLogin.this, MovieListActivity.class));
                finish();
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException exception) {
                Toast.makeText(FacebookLogin.this,
                        "Something went wrong pls try again later", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
