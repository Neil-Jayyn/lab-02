package com.example.listcity;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    //Declaring vars to reference later
    ListView cityList;
    ArrayAdapter<String> cityAdapter;
    ArrayList<String> dataList;

    Button addButton;
    Button deleteButton;
    Button confirmButton;

    EditText cityTextbox;
    LinearLayout confirmLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        //--LAB DEMO LISTVIEW stuff
        cityList=findViewById(R.id.city_list);

        String []cities={"Edmonton", "Vancouver", "Moscow","Sydney","Tokyo","Beijing", "Almaty", "Astana", "New Delhi"};

        dataList= new ArrayList<>();
        dataList.addAll(Arrays.asList(cities));

        cityAdapter=new ArrayAdapter<>(this, R.layout.content,dataList);
        cityList.setAdapter(cityAdapter);

        //--BUTTON FUNCTIONALITY
        addButton=findViewById(R.id.add_button);
        deleteButton=findViewById(R.id.delete_button);

        confirmButton=findViewById(R.id.confirm_button);
        confirmLayout=findViewById(R.id.confirm_layout);
        cityTextbox=findViewById(R.id.city_textbox);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //Show Confirm Layout that has textbox + confirm button
                confirmLayout.setVisibility(VISIBLE);
            }
        });

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get value of textbox
                String cityText=String.valueOf(cityTextbox.getText());
                //add city to list & update listview
                dataList.add(cityText);
                cityAdapter.notifyDataSetChanged();
                //hide confirm layout
                confirmLayout.setVisibility(INVISIBLE);
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //tap city then press delete button to delete the list
            }
        });


    }
}