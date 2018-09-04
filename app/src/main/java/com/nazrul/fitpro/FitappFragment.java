package com.nazrul.fitpro;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FitappFragment extends Fragment {

    ImageView imgGit, imgFB, imgIn;


    public FitappFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View MainView = inflater.inflate(R.layout.fragment_fitapp, container, false);

        imgGit = MainView.findViewById(R.id.imageViewGit);
        imgFB = MainView.findViewById(R.id.imageViewFB);
        imgIn = MainView.findViewById(R.id.imageViewLinkedin);


        imgGit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/mnislam01"));
                startActivity(intent);
            }
        });

        imgFB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/mnislam01"));
                startActivity(intent);
            }
        });

        imgIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/mnislam01"));
                startActivity(intent);
            }
        });

        return MainView;
    }

}
