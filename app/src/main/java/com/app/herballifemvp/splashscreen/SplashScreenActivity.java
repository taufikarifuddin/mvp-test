package com.app.herballifemvp.splashscreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.app.herballifemvp.home.MainActivity;
import com.app.herballifemvp.R;

/**
 * Created by Taufik on 07/16/17.
 */

public class SplashScreenActivity extends AppCompatActivity implements SplashScreenContract.View{

    public ProgressBar bar;
    public TextView txt;
    SplashScreenContract.Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        bar = (ProgressBar) findViewById(R.id.prog);
        txt = (TextView) findViewById(R.id.load);

        presenter = new SplashScreenPresenter(this);
    }
//
//    @Override
//    public void setPresenter(SplashScreenContract.Presenter presenter) {
//        this.presenter = presenter;
//    }

    @Override
    public void navigateToMenu() {
        Log.d("called","changeToMenu");
        startActivity(new Intent(this, MainActivity.class));
        this.finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.presenter.onStart();
    }
}
