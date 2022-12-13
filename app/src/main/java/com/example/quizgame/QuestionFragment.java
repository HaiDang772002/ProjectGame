package com.example.quizgame;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QuestionFragment extends Fragment implements View.OnClickListener{
    public QuestionFragment() {}
    public QuestionFragment(int count,int point) {
       this.count =count;
       this.point =point;
    }
TextView myQuestion;
    LinearLayout myAnswer1,myAnswer2;
    TextView myQuestionOrder;
    static int count;
    static int point;
    static List<Integer> intList = Arrays.asList(new Integer[]{0, 1, 2, 3, 4});
    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_question, container, false);

        int index=PlayFragment.subject*5+intList.get(QuestionFragment.count);
        String questionItem=QuestionList.Question[index][LevelFragment.level];

       myQuestionOrder=view.findViewById(R.id.question_order);
       myQuestion=view.findViewById(R.id.myquestion);
       myQuestion.setText(questionItem);
      myAnswer1=view.findViewById(R.id.correct);
      myAnswer2=view.findViewById(R.id.incorrect);
      myAnswer1.setOnClickListener(this);
      myAnswer2.setOnClickListener(this);
      myQuestionOrder.setOnClickListener(this);

      myQuestionOrder.setText(count + 1 +"/5");
       return view;
    }

    @Override
    public void onClick(View view) {
       if(getResources().getResourceEntryName(view.getId()).equals(String.valueOf(QuestionList.Answer[PlayFragment.subject*5+QuestionFragment.count][LevelFragment.level]))){
           point+=1;
        }

        if(count==4){
            requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.containers,new PointFragment()).commit();
        }
        else {
            count+=1;
        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.containers,new QuestionFragment(count,point)
        ).commit();
    }
    }

}