package com.example.android.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetailFragment extends Fragment {

   private String mButtonText;

    public void setButtonText(String buttonText) {
        mButtonText = buttonText;
    }

    public DetailFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if(savedInstanceState != null) {
            mButtonText = savedInstanceState.getString("KEY");
        }
        //TODO 14 create a fragment_detail xml and inflate it
        final View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
        TextView textView = rootView.findViewById(R.id.textView_result);
        textView.setText(mButtonText);
        return rootView;
    }


    @Override
    public void onSaveInstanceState(Bundle currentState) {
        currentState.putString("KEY", mButtonText);
    }



}
