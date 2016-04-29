package com.sevencstudio.harish.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void showToast(View v)
    {
        Toast.makeText(MainActivity.this, "testing CI more", Toast.LENGTH_SHORT).show();
    }
}
