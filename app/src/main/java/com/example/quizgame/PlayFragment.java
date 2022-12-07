package com.example.quizgame;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

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
        mySubject1=(LinearLayout) view.findViewById(R.id.geography);
        mySubject2=(LinearLayout) view.findViewById(R.id.history);
        mySubject3=(LinearLayout) view.findViewById(R.id.science);
        mySubject4=(LinearLayout) view.findViewById(R.id.art);
        mySubject1.setOnClickListener(this::onClick);
        mySubject2.setOnClickListener(this::onClick);
        mySubject3.setOnClickListener(this::onClick);
        mySubject4.setOnClickListener(this::onClick);
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
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.containers, levelFragment).commit();
        Log.d("The sub_num is ", String.valueOf(subject));
    }


}