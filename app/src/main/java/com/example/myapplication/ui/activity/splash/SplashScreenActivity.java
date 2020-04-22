package com.example.myapplication.ui.activity.splash;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;

import com.example.myapplication.R;
import com.example.myapplication.ui.activity.mainActivity.MainActivity;
import com.example.myapplication.ui.base.BaseActivity;

public class SplashScreenActivity extends BaseActivity implements SplashScreenContract.View {
    private SplashScreenContract.Presenter mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mPresenter = new SplashScreenPresenter(this);
        mPresenter.startActivityTimeOut();

    }

    @Override
    public void startMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
