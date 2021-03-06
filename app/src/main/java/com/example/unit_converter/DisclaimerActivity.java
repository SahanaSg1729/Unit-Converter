package com.example.unit_converter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import java.util.Objects;

public class DisclaimerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disclaimer);
        Toolbar toolbar = findViewById(R.id.toolbar_disclaimer);
        setSupportActionBar(toolbar);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        MainActivity.BACK_FROM_CHILD_KEY = "more_fragment";
        return super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        MainActivity.BACK_FROM_CHILD_KEY = "more_fragment";
        super.onSupportNavigateUp();
    }
}