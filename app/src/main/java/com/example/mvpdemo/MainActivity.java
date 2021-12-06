package com.example.mvpdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private static final String TAG = "MainActivity";
    private MainContract.Presenter mPresenter;

    private Button mButton;

    private TextView myTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Создаём Presenter и в аргументе передаём ему this - эта Activity расширяет интерфейс MainContract.View
        mPresenter = (MainContract.Presenter) new MainPresenter(this);
        myTv = (TextView) findViewById(R.id.text_view);
        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.onButtonWasClicked();
            }
        });
        Log.d(TAG, "onCreate()");

    }

    @Override
    public void showText(String message) {
        myTv.setText(message);
        Log.d(TAG, "showMessage()");

    }


}