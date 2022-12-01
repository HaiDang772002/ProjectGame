package com.example.quizgame;

import static com.example.quizgame.R.id.geography;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class PlayFragment extends Fragment {
    LinearLayout myFragmentButton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view1=inflater.inflate(R.layout.fragment_play, container, false);
        myFragmentButton=(LinearLayout) view1.findViewById(R.id.geography);
        myFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myFragmentButton.setBackgroundColor(getResources().getColor(R.color.black));
            }
        });
        return view1;
    }
}