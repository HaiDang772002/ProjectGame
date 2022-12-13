package com.example.quizgame;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
public class HistoryFragment extends Fragment {
    RecyclerView recyclerView;
    List<Task> tasks=new ArrayList<>();
    MyHistoryAdapter myHistoryAdapter;
    Database database;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_history, container, false);
        database=new Database(requireContext());
        tasks=database.getTasks();
        recyclerView=view.findViewById(R.id.recycleView);
        myHistoryAdapter=new MyHistoryAdapter(tasks);
        recyclerView.setAdapter(myHistoryAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),1));
        return view;
    }
}