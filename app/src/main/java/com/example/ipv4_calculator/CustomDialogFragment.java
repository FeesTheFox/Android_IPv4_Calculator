package com.example.ipv4_calculator;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class CustomDialogFragment extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        //creating builder of a dialog window
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());

        //setting the message of a dialog window
        builder.setMessage("Are you sure you want to leave the app?");

        //adding the button "YES"
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //close the app
                requireActivity().finish();
            }
        });

        //adding the button "NO"
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //CANCEL THE DIALOG WINDOW
                dialog.dismiss();
            }
        });

        //Build and return dialog window
        return builder.create();
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("CustomDialogFragment", "onCreate");
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("CustomDialogFragment", "onCreateView");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("CustomDialogFragment", "onViewCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("CustomDialogFragment", "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("CustomDialogFragment", "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("CustomDialogFragment", "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("CustomDialogFragment", "onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("CustomDialogFragment", "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("CustomDialogFragment", "onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("CustomDialogFragment", "onDetach");
    }
}
