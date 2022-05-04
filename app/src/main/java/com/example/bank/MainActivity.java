package com.example.bank;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.time.MonthDay;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    RecyclerView recycler_view;
    String incom, filter;
    String amount, data;
    ImageView button_id, filter_id;
    List<ModelClass> mData = new ArrayList<>();
    List<ModelClass> l1 = new ArrayList<>();
    //    String[] name = {"ABC","DEF","GHI","FRG"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding();
        adapter(l1);

        button_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.dailog_design);

                Button add_btn = dialog.findViewById(R.id.add_btn);
                RadioGroup category_brn = dialog.findViewById(R.id.category_brn);
                EditText amount_edt = dialog.findViewById(R.id.amount_edt);
                EditText adddata_edt = dialog.findViewById(R.id.adddata_edt);

                add_btn.setOnClickListener(new View.OnClickListener() {
                    @SuppressLint("ResourceAsColor")
                    @Override
                    public void onClick(View view) {
                        amount = amount_edt.getText().toString();
                        data = adddata_edt.getText().toString();

                        if (category_brn.getCheckedRadioButtonId() == R.id.incom_rd) {
                            incom = "Income";
                        } else if (category_brn.getCheckedRadioButtonId() == R.id.expence_rd) {
                            incom = "Expense";
                        }
                        dialog.dismiss();
                        ModelClass modelClass = new ModelClass(amount, data, incom);
                        l1.add(modelClass);

                        Toast.makeText(MainActivity.this, "" + amount + data + incom, Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();
            }
        });

        filter_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog1 = new Dialog(MainActivity.this);
                dialog1.setContentView(R.layout.dailog_filter);

                RadioGroup filtergrp_ic = dialog1.findViewById(R.id.filtergrp_ic);
                TextView add_filter = dialog1.findViewById(R.id.add_filter);

                add_filter.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (filtergrp_ic.getCheckedRadioButtonId() == R.id.income_filter) {
                            filter = "Income";
                        } else if (filtergrp_ic.getCheckedRadioButtonId() == R.id.expense_filter) {
                            filter = "Expense";
                        }

                        Toast.makeText(MainActivity.this, "" + filter, Toast.LENGTH_SHORT).show();

                        filter_data(filter);
                        dialog1.dismiss();
                    }
                });
                dialog1.show();

            }
        });
    }

    private void binding() {
        recycler_view = (RecyclerView) findViewById(R.id.recycler_view);
        button_id = (ImageView) findViewById(R.id.button_id);
        filter_id = (ImageView) findViewById(R.id.filter_id);
    }
    void filter_data(String filter)
    {
        List<ModelClass> filterList = l1;
        mData.clear();
        for(int i=0;i<filterList.size();i++)
        {
            if(filterList.get(i).getIncome().equals(filter)){
                mData.add(filterList.get(i));
            }
        }
        adapter(mData);
    }
    void adapter(List<ModelClass> list)
    {
        DeatailsAdaptor deatailsAdaptor = new DeatailsAdaptor(MainActivity.this, list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recycler_view.setLayoutManager(layoutManager);
        recycler_view.setAdapter(deatailsAdaptor);
    }
}