package com.example.quizgame;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class LevelFragment extends Fragment implements View.OnClickListener {
    static int level=0;
    public LevelFragment() {
    }
    QuestionFragment questionFragment=new QuestionFragment();
    LinearLayout myLevel1,myLevel2,myLevel3;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_level, container, false);
        myLevel1=(LinearLayout) view.findViewById(R.id.easy);
        myLevel2=(LinearLayout) view.findViewById(R.id.medium);
        myLevel3=(LinearLayout) view.findViewById(R.id.difficult);

        myLevel1.setOnClickListener(this::onClick);
        myLevel2.setOnClickListener(this::onClick);
        myLevel3.setOnClickListener(this::onClick);
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
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.containers,questionFragment).commit();
        Log.d("The level_num is", String.valueOf(level));
}
}