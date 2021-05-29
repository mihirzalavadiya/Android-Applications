package com.example.fragementdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Switch sw = findViewById(R.id.switch1);

        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    FirstFrag firstFrag = new FirstFrag();
                    fragmentTransaction.replace(R.id.fragment_container, firstFrag);
                    fragmentTransaction.commit();
                }
                else {
                    fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    SecondFrag secondFrag = new SecondFrag();
                    fragmentTransaction.replace(R.id.fragment_container, secondFrag);
                    fragmentTransaction.commit();
                }
            }
        });
    }
}