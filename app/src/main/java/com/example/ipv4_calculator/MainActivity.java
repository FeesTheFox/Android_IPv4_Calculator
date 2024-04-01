package com.example.ipv4_calculator;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.ipv4_calculator.databinding.ActivityMainBinding;
import com.example.ipv4_calculator.databinding.Fragment1Binding;

public class MainActivity extends AppCompatActivity {

    private static final int CONTENT_VIEW_ID = 10101010;
    private ActivityMainBinding binding;
    private Fragment1 fragment1;
    private Fragment2 fragment2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater()); //work with binding
        View view = binding.getRoot();
        setContentView(view);

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();

        binding.fragment1ContainerView.setId(CONTENT_VIEW_ID);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        setTitle("IPv4 Calculator");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_author: // ID of the 1st item
                Toast.makeText(this, "Fees The Fox", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.menu_info: // ID of the 2nd item
                Toast.makeText(this, "Is an IPv4 app", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.home:
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(CONTENT_VIEW_ID,fragment1);
                transaction.addToBackStack(null);
                transaction.commit();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}