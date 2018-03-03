package com.example.android.fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class MainFragment extends Fragment {
    Button mButton1;

    //TODO 5 create an empty constructor
    public MainFragment() {
    }

    //TODO 6 Override onCreateView
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        //TODO 7 inflate the xml layout you created
        final View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        //TODO 10 set up the views
        final Button button1 = rootView.findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO 11 when a button is tapped we take its text and pass it as an argument to the mListener interface
                String buttonText = button1.getText().toString();
                mListener.onButtonTapped(buttonText);
            }
        });

        final Button button2 = rootView.findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String buttonText = button2.getText().toString();
                mListener.onButtonTapped(buttonText);
            }
        });

        final Button button3 = rootView.findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String buttonText = button3.getText().toString();
                mListener.onButtonTapped(buttonText);
            }
        });

        return rootView;
    }

    //TODO 8 ADD an interface that will be implemented by the parent activity
    ButtonClickListener mListener;

    public interface ButtonClickListener {
        void onButtonTapped(String buttonText);
    }


    //TODO 9 override onAttach to make sure parent activity is implementing the interface
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (ButtonClickListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + "ButtonClickListener is not implemented");
        }
    }
}
