package com.example.ipv4_calculator;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ipv4_calculator.databinding.Fragment2Binding;


public class Fragment2 extends Fragment {
    private Fragment2Binding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        super.onCreate(savedInstanceState);
        binding = Fragment2Binding.inflate(inflater, container,false); //work with binding
        View view = binding.getRoot();



        Bundle bundle = getArguments();
        binding.maskLenght.setText(bundle.getString("MaskLength"));
        binding.IPRange.setText(bundle.getString("IPRange"));
        binding.subAdress.setText(bundle.getString("SubIP"));
        binding.broadcast.setText(bundle.getString("BroadcastIP"));



        binding.btnBa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.remove(Fragment2.this);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        return view;
    }


}