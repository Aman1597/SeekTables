package com.example.seektables;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int num1=1, num2 = 20;
    Random rand = new Random();
    ListView myListView;
    ArrayList<String> table = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;
    SeekBar seekBar;
    EditText ed1,ed2;
    TextView lowerLimit, upperLimit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myListView = findViewById(R.id.myListView);
        seekBar = findViewById(R.id.seekBar);
        lowerLimit = findViewById(R.id.lowerLimit);
        upperLimit = findViewById(R.id.upperLimit);
        ed1=findViewById(R.id.editTextNumber);
        ed2=findViewById(R.id.editTextNumber2);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, table){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView textView=(TextView) view.findViewById(android.R.id.text1);
                //textView.setTextColor(Color.WHITE);

                return view;//super.getView(position, convertView, parent);
            }
        };

        displayOnList(num1,num2);

        seekBar.setMax(19);
        lowerLimit.setText("1");
        upperLimit.setText(""+20);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser)
                    displayOnList(progress+1,num2);
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
        num1 = Integer.parseInt( ed1.getText().toString());
        num2 = Integer.parseInt( ed2.getText().toString());
        if(num1>=1 && num1<=20){
            int p = num1-1;
            seekBar.setProgress(p);
        }
        else{
            int x = rand.nextInt(95) + 5;
            seekBar.setMax(num1+x);
            int y = num1+x+1;
            upperLimit.setText(""+y);
            seekBar.setProgress(num1-1);
        }

        displayOnList(num1,num2);
    }

    public void displayOnList(int num1, int num2){
        table.clear();
        for(int i=1;i<=num2;i++){
            table.add(num1 + " X " + i + " = " + num1*i);
        }
        int x = seekBar.getProgress() + 1;
        lowerLimit.setText(""+x);
        //ed1.setText(""+x);
        myListView.setAdapter(arrayAdapter);
    }
}