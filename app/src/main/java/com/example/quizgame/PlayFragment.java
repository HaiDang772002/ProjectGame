package com.example.quizgame;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class PlayFragment extends Fragment implements View.OnClickListener {
   static int subject=0;
   LevelFragment levelFragment=new LevelFragment();
    public PlayFragment(){

    }

    LinearLayout mySubject1,mySubject2,mySubject3,mySubject4;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)  {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_play, container, false);
        mySubject1=view.findViewById(R.id.geography);
        mySubject2= view.findViewById(R.id.history);
        mySubject3=view.findViewById(R.id.science);
        mySubject4= view.findViewById(R.id.art);
        mySubject1.setOnClickListener(this);
        mySubject2.setOnClickListener(this);
        mySubject3.setOnClickListener(this);
        mySubject4.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == mySubject1.getId()) {
            subject = 0;
        } else if (view.getId() == mySubject2.getId()) {
            subject = 1;
        } else if (view.getId() == mySubject3.getId()) {
            subject = 2;
        } else if (view.getId() == mySubject4.getId()) {
            subject = 3;
        }
        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.containers, levelFragment).commit();
        Log.d("The sub_num is ", String.valueOf(subject));
    }


}