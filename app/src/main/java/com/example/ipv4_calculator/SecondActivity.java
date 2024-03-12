package com.example.ipv4_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.ipv4_calculator.databinding.ActivityMainBinding;
import com.example.ipv4_calculator.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {
    private ActivitySecondBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecondBinding.inflate(getLayoutInflater()); //work with binding
        View view = binding.getRoot();
        setContentView(view);


        Intent intent = getIntent();
        binding.maskLenght.setText(intent.getStringExtra("MaskLength"));
        binding.IPRange.setText(intent.getStringExtra("IPRange"));
        binding.subAdress.setText(intent.getStringExtra("SubIP"));
        binding.broadcast.setText(intent.getStringExtra("BroadcastIP"));



        binding.btnBa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish(); //finishes the SecondActivity, then goes back to MainActivity
            }
        });




    }


}