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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class PointFragment extends Fragment implements View.OnClickListener{
    static ArrayList<Task> taskList=new ArrayList<>();
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
            addHistory();
            saveData();
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
        Collections.shuffle(QuestionFragment.intList);
    }
    private void saveData(){
        Database database=new Database(requireContext());
        database.saveTasks(taskList);
    }
    private void addHistory(){
        String point=String.valueOf(QuestionFragment.point)+"/"+"5";
        String subject=String.valueOf(PlayFragment.subject);
        String level=String.valueOf(LevelFragment.level);

        if(subject.equals("0")) subject = "Địa lý";
        else if(subject.equals("1")) subject="Lịch sử";
        else if(subject.equals("2")) subject="Khoa học";
        else if(subject.equals("3")) subject="Nghệ thuật";

        if(level.equals("0")) level="Dễ";
        if(level.equals("1")) level="Trung Bình";
        if(level.equals("2")) level="Khó";

        taskList.add(new Task(point,subject,level));
    }
}