package com.example.seektables;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int num1=1, num2 = 20;
    ListView myListView;
    ArrayList<String> table = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;
    SeekBar seekBar;
    TextView lowerLimit, upperLimit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myListView = findViewById(R.id.myListView);

        for(int j=1;j<=num2;j++){
            table.add(1 + " X " + j + " = " + 1*j);
        }

        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, table);
        myListView.setAdapter(arrayAdapter);

        seekBar = findViewById(R.id.seekBar);
        seekBar.setMax(19);
        lowerLimit = findViewById(R.id.lowerLimit);
        upperLimit = findViewById(R.id.upperLimit);
        lowerLimit.setText("1");
        upperLimit.setText(""+20);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser){
                    table.clear();
                    int a = progress + 1;
                    for(int i=1;i<=num2;i++){
                        table.add(a + " X " + i + " = " + a*i);
                    }
                    myListView.setAdapter(arrayAdapter);
                }


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    public void printTable(View view){
        EditText ed1=findViewById(R.id.editTextNumber);
        num1 = Integer.parseInt( ed1.getText().toString());
        EditText ed2=findViewById(R.id.editTextNumber2);
        num2 = Integer.parseInt( ed2.getText().toString());
        if(num1>=1 && num1<=20){
            int p = num1-1;
            seekBar.setProgress(p);
        }
        else{
            int x = new Random().nextInt(95) + 5;
            seekBar.setMax(num1+x);
            int y = num1+x+1;
            upperLimit.setText(""+y);
            seekBar.setProgress(num1);
        }
        table.clear();
        for(int i=1;i<=num2;i++){
            table.add(num1 + " X " + i + " = " + num1*i);
        }
        myListView.setAdapter(arrayAdapter);
    }
}