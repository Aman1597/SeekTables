package com.example.seektables;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //int num1=1, num2 = 20;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView myListView = findViewById(R.id.myListView);
        ArrayList<String> table = new ArrayList<>();
        for(int j=1;j<=20;j++){
            table.add(1 + " X " + j + " = " + 1*j);
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, table);
        myListView.setAdapter(arrayAdapter);

        SeekBar seekBar = findViewById(R.id.seekBar);
        seekBar.setMax(19);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                table.clear();
                int a = progress + 1;
                for(int i=1;i<=20;i++){
                    table.add(a + " X " + i + " = " + a*i);
                }
                myListView.setAdapter(arrayAdapter);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
//    public void printTable(View view){
//        EditText ed1=findViewById(R.id.editTextNumber);
//        num1 = Integer.parseInt( ed1.getText().toString());
//        EditText ed2=findViewById(R.id.editTextNumber2);
//        num2 = Integer.parseInt( ed2.getText().toString());
//        if(num1>=1 && num1<=20){
//            int p = num1-1;
//            seekBar.setProgress(p);
//        }
//        table.clear();
//        for(int i=1;i<=num2;i++){
//            table.add(num1 + " X " + i + " = " + num1*i);
//        }
//        myListView.setAdapter(arrayAdapter);
//    }
}