package com.example.android.fragments;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
//TODO 13 create a detailFragment

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

       if(savedInstanceState == null) {
           //TODO 15 create a new instance of detail fragment
        String buttonText = getIntent().getStringExtra("button_text");
            DetailFragment detailFragment = new DetailFragment();
             detailFragment.setButtonText(buttonText);
             //TODO 16 use fragment manager to add fragment.
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .add(R.id.container1, detailFragment)
                    .commit();
        }
    }
}
