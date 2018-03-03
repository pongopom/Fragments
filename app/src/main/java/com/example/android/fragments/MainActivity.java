package com.example.android.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements MainFragment.ButtonClickListener {


    //TODO 1. create a new java class that extends fragment
    //TODO 2 create a new fragment layout xml file. follow the naming conventions as you would for an activity layout
    // TODO 3. add a fragment view to the main activities layout xml

private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.tablet_layout) != null){

            mTwoPane = true;

            if(savedInstanceState == null) {
                //TODO 15 create a new instance of detail fragment
                String buttonText = getIntent().getStringExtra("button_text");
                DetailFragment detailFragment = new DetailFragment();
                detailFragment.setButtonText("");
                //TODO 16 use fragment manager to add fragment.
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .add(R.id.container1, detailFragment)
                        .commit();
            }

        }else{
            mTwoPane = false;
        }

    }

    @Override
    public void onButtonTapped(String buttonText) {
    //  TODO 12 create a detail activity

if (mTwoPane){

    DetailFragment detailFragment = new DetailFragment();
    detailFragment.setButtonText(buttonText);
    //TODO 16 use fragment manager to add fragment.
    FragmentManager fragmentManager = getSupportFragmentManager();
    fragmentManager.beginTransaction()
            .replace(R.id.container1, detailFragment)
            .commit();
       }
        else{

    Bundle b = new Bundle();
    b.putString("button_text", buttonText);
    Intent intent = new Intent(this, DetailActivity.class);
    intent.putExtras(b);
    startActivity(intent);
        }

    }
}
