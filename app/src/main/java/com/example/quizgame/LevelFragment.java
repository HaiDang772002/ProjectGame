package com.example.quizgame;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class LevelFragment extends Fragment implements View.OnClickListener {
    static int level=0;
    public LevelFragment() {
    }
    LinearLayout myLevel1,myLevel2,myLevel3;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_level, container, false);
        myLevel1= view.findViewById(R.id.easy);
        myLevel2= view.findViewById(R.id.medium);
        myLevel3= view.findViewById(R.id.difficult);

        myLevel1.setOnClickListener(this);
        myLevel2.setOnClickListener(this);
        myLevel3.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == myLevel1.getId()) {
            level= 0;
        } else if (view.getId() == myLevel2.getId()) {
            level = 1;
        } else if (view.getId() == myLevel3.getId()) {
           level= 2;
    }
        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.containers,new QuestionFragment(0,0)).commit();
        Log.d("The level_num is", String.valueOf(level));
}
}