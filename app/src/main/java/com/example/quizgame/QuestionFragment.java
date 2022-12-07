package com.example.quizgame;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class QuestionFragment extends Fragment implements View.OnClickListener{
    public QuestionFragment() {

    }
    public QuestionFragment(int count,int point) {
       this.count=count;
       this.point=point;
    }
TextView myQuestion;
    LinearLayout myAnswer1,myAnswer2;
    TextView myQuestionOrder;
    static int count;
    static int point;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_question, container, false);
        int index=PlayFragment.subject*5+QuestionFragment.count;
        String questionItem=QuestionList.Question[index][LevelFragment.level];
       myQuestionOrder=view.findViewById(R.id.question_order);
       myQuestion=view.findViewById(R.id.myquestion);
       myQuestion.setText(questionItem);
      myAnswer1=view.findViewById(R.id.correct);
      myAnswer2=view.findViewById(R.id.incorrect);
      myAnswer1.setOnClickListener(this::onClick);
      myAnswer2.setOnClickListener(this::onClick);
      myQuestionOrder.setOnClickListener(this::onClick);
        myQuestionOrder.setText(String.valueOf(count+1)+"/5");
Log.d("Count", String.valueOf(count));
       return view;
    }

    @Override
    public void onClick(View view) {
        String ab=QuestionList.Answer[PlayFragment.subject*5+QuestionFragment.count][0];
        Log.d("Point",ab);
        if(view.getId()==myAnswer1.getId()){
            point+=1;
        }
        if(count==4){
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.containers,new HistoryFragment()).commit();
            count=0;
            Log.d("Point",String.valueOf(point));
            point=0;
        }
        else {
            count+=1;
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.containers,new QuestionFragment(count,point)
        ).commit();

    }

}}