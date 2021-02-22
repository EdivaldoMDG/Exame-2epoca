package com.example.preparacao_exame_2epoca;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

//Primeiro o extends extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder>  que vai criar os metedos sozinho

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    Context context;
    private final LinkedList<Aluno> mStudentList_A;
    private LayoutInflater mInflater;

   //Depois um Student Adar com as instancias
    public StudentAdapter(Context context,LinkedList<Aluno> mStudentList ){
        mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mStudentList_A = mStudentList;
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder {
        public TextView nomeTV,numeroTv,pcTv;

        public StudentViewHolder(@NonNull View itemView, StudentAdapter studentAdapter) {
            super(itemView);
            nomeTV = itemView.findViewById(R.id.tv_pc2);
            numeroTv = itemView.findViewById(R.id.tv_numero2);
            pcTv = itemView.findViewById(R.id.tv_pc2);
        }
    }

//Terceiro
    @NonNull
    @Override
    public StudentAdapter.StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Criar um viewItemView
         View mItemView = mInflater.inflate(R.layout.studen_item,parent,false);

         return new StudentViewHolder(mItemView,this);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentAdapter.StudentViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mStudentList_A.size();
    }


}
