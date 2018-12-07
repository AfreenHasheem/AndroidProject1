package com.example.afreen.androiddevelopertest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    Button btnTapMe, btnTapped;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTapMe = findViewById(R.id.btn_TapMe);
        btnTapped = findViewById(R.id.btn_Tapped);
        click_action();
    }

    private void click_action() {

        btnTapMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnTapMe.setVisibility(View.INVISIBLE);
                btnTapped.setVisibility(View.VISIBLE);
                Intent intent = new Intent(getApplicationContext(), UserProfileActivity.class);
                startActivity(intent);
            }
        });
    }
}
