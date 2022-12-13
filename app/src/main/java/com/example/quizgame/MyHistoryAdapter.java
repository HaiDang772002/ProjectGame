package com.example.quizgame;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyHistoryAdapter extends RecyclerView.Adapter<MyHistoryAdapter.MyViewHolder> {
    private List<Task> listTask;

    public MyHistoryAdapter(List<Task> listTask) {
        this.listTask=listTask;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.myhistory_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Task task=listTask.get(position);
        holder.point.setText(task.getPoint());
        holder.level.setText(task.getLevel());
        holder.subject.setText(task.getSubject());
    }

    @Override
    public int getItemCount() {
        return listTask.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView point, subject, level;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            point=itemView.findViewById(R.id.point_item);
            subject=itemView.findViewById(R.id.subject_item);
            level=itemView.findViewById(R.id.level_item);
        }
    }
}
