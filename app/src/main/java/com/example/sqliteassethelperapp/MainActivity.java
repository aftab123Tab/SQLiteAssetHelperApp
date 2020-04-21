package com.example.sqliteassethelperapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
     MyDbclass objMyDbClass;
ArrayList<DbModelClass> objDbModelClassArrayList;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        objMyDbClass=new MyDbclass(this);
        objDbModelClassArrayList=new ArrayList<>();
         recyclerView=findViewById(R.id.dataRV);
    }

    public void showdata(View view)
    {
        try{
            objDbModelClassArrayList=objMyDbClass.getAllData();
            DbAdapter objDbAdapter=new DbAdapter(objDbModelClassArrayList);
            recyclerView.hasFixedSize();
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(objDbAdapter);


        }catch (Exception e)
        {
            Toast.makeText(this,"ShowData"+e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }
}
