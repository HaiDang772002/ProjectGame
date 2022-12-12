package com.example.quizgame;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class PointFragment extends Fragment implements View.OnClickListener{

    public PointFragment() {

    }
Button complete_btn, share_btn;
    TextView totalPoint;
    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_point, container, false);
        complete_btn=view.findViewById(R.id.complete);
        share_btn=view.findViewById(R.id.share);
        totalPoint=view.findViewById(R.id.point);
        totalPoint.setText(QuestionFragment.point +"/5");
        complete_btn.setOnClickListener(this);
        share_btn.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==complete_btn.getId()){
            requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.containers,new PlayFragment()).commit();
        }
        else if (view.getId()==share_btn.getId()){
            Intent share=new Intent(Intent.ACTION_SEND);
            share.putExtra(Intent.EXTRA_TEXT,"Tôi vừa mới trả lời đúng "+totalPoint.getText()+" câu hỏi");
            share.setType("text/plain");
            startActivity(share);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        QuestionFragment.point=0;
        QuestionFragment.count=0;
    }
}