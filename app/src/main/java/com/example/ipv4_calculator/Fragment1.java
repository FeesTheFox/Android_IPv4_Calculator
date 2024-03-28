package com.example.ipv4_calculator;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ipv4_calculator.databinding.Fragment1Binding;


public class Fragment1 extends Fragment implements View.OnClickListener {
    private static final int CONTENT_VIEW_ID = 10101010;

    private Fragment1Binding binding;
    private Fragment2 fragment2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = Fragment1Binding.inflate(inflater, container, false); //work with binding
        View view = binding.getRoot();
        binding.btnCalculate.setOnClickListener(this);
        binding.btnExit.setOnClickListener(View->System.exit(0));

        binding.btnForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String text = binding.editText.getText().toString(); //IPv4
                    Bundle bundle = new Bundle(); //transferring data through bundle
                    int spinner_pos = binding.spinner.getSelectedItemPosition(); //Position of a mask
                    String spinner_value = binding.spinner.getSelectedItem().toString(); //Value of a mask position
                    bundle.putString("MaskLength", String.valueOf(lengthCalculate(spinner_pos))+"  -Length of mask");
                    String resSubAddress =subIp(spinner_value, text);
                    String resBroadcast =broadcastIp(spinner_value, text);
                    bundle.putString("IPRange", String.format("%s to %s", resSubAddress, resBroadcast) + "  -Address range");
                    bundle.putString("SubIP", resSubAddress + "  -Subnet address");
                    bundle.putString("BroadcastIP", resBroadcast + "  -Broadcast address");

                    fragment2 = new Fragment2();
                    fragment2.setArguments(bundle);


                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(CONTENT_VIEW_ID,fragment2);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
                catch (Exception e){}
            }

        });
        return view;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getContext(), Fragment2.class);
        try {
            String text = binding.editText.getText().toString(); //IPv4

            int spinner_pos = binding.spinner.getSelectedItemPosition(); //Position of a mask
            String spinner_value = binding.spinner.getSelectedItem().toString(); //Value of a mask position
            intent.putExtra("MaskLength", String.valueOf(lengthCalculate(spinner_pos)) + "  -Length of mask");
            String resSubAddress = subIp(spinner_value, text);
            String resBroadcast = broadcastIp(spinner_value, text);
            intent.putExtra("IPRange", String.format("%s to %s", resSubAddress, resBroadcast) + "  -Address range");
            intent.putExtra("SubIP", resSubAddress + "  -Subnet address");
            intent.putExtra("BroadcastIP", resBroadcast + "  -Broadcast address");
            startActivity(intent);
        } catch (Exception e) {
        }
    }

    public int lengthCalculate(int spinner_pos) { //Calculates the length of mask
        int result = 32 - spinner_pos;
        return result;
    }

    public int toBinary(String dot) { //transferring dot into binary
        String[] split = dot.split("\\."); //splitting dot
        if (split.length != 4){
            throw new RuntimeException("Wrong Length");
        }
        int value = 0;
        int shift = 32;
        for (String s : split) {
            value ^= Integer.parseInt(s) << shift; //XOR
            shift -= 8; //shift goes by 8
        }
        return value;
    }
    public String toDot(int bin) { //transferring binary into dot
        StringBuilder data = new StringBuilder(); //Constructing StringBuilder
        for (int i = 3; i >= 0; i--) {  //from 0 to 3
            int val = bin >>> ((i + 1) << 3); //shift goes by 8
            val &= 0xFF; //Extraction of 8 bytes
            data.append(val); //Constructing the String
            if (i != 0) data.append("."); //Placing "." after a number
        }
        return data.toString();
    }


    public String subIp(String spinner_value,String text){ //Finding the min Ip
        int mask = toBinary(spinner_value);
        int ip = toBinary(text);
        return toDot(mask & ip);
    }

    public String broadcastIp(String spinner_value, String text){ //Finding the max Ip
        int mask = toBinary(spinner_value);
        int ip = toBinary(text);
        return toDot(~mask | ip);
    }

}