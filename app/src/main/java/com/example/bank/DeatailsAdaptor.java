package com.example.bank;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DeatailsAdaptor extends RecyclerView.Adapter<DeatailsAdaptor.ViewData> {

    Activity activity;
    List<ModelClass> l1 = new ArrayList();

    public DeatailsAdaptor(MainActivity mainActivity, List<ModelClass> l1) {
        activity = mainActivity;
//        this.name = name;
//        this.amount = amount;
        this.l1 = l1; }
    @NonNull
    @Override
    public ViewData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(activity).inflate(R.layout.item_design,parent,false);
        return new ViewData(view); }


    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull ViewData holder, @SuppressLint("RecyclerView") int position) {
//            holder.txt_id.setText(name[position]);
        holder.txt_id.setText(l1.get(position).getAmount());
        holder.data_id.setText(l1.get(position).getData());

        if(l1.get(position).getIncome().equals("Income")){
            holder.category_id.setTextColor(Color.GREEN);
        }
        if(l1.get(position).getIncome().equals("Expense")){
            holder.category_id.setTextColor(Color.RED);
        }
        holder.category_id.setText(l1.get(position).getIncome());
//
//        holder.txt_id.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(activity, ""+name[position], Toast.LENGTH_SHORT).show();
//            }
//        });
    }
    @Override
    public int getItemCount() {
        return l1.size();
    }
    public static class ViewData extends RecyclerView.ViewHolder {
        TextView txt_id,data_id,category_id;
        LinearLayout card_background;
        public ViewData(@NonNull View itemView) {
            super(itemView);
            txt_id = (TextView) itemView.findViewById(R.id.txt_id);
            data_id = (TextView) itemView.findViewById(R.id.data_id);
            category_id = (TextView) itemView.findViewById(R.id.category_id);
            card_background = itemView.findViewById(R.id.card_background);
        }
    }
}
