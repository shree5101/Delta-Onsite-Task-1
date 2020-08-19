package com.example.android.canvasrectangle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.android.canvasrectangle.views.CustomView;

public class MainActivity extends AppCompatActivity {

    private CustomView mCustomView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCustomView = findViewById(R.id.custom_view);
    }
}