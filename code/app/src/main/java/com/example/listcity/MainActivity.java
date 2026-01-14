package com.example.listcity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
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



        cityList=findViewById(R.id.city_list);

        String []cities={"Edmonton", "Vancouver", "Moscow","Sydney","Tokyo","Beijing", "Almaty", "Astana", "New Delhi"};

        dataList= new ArrayList<>();
        dataList.addAll(Arrays.asList(cities));

        cityAdapter=new ArrayAdapter<>(this, R.layout.content,dataList);
        cityList.setAdapter(cityAdapter);

        addButton=findViewById(R.id.add_button);
        deleteButton=findViewById(R.id.delete_button);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Buttons","Add button clicked");
                dataList.remove();
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Buttons","Delete button clicked");
            }
        });


    }
}