package com.nazrul.fitpro;

/**Title: Fitapp
 * Author: Md. Nazrul Islam
 *
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextDirectionHeuristic;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;


/**
 * A simple {@link Fragment} subclass.
 */
public class BMRFragment extends Fragment {

    TextView TextViewResult;
    CheckBox CheckBoxMale, CheckBoxFemale;
    EditText EditTextHeight, EditTextWeight, EditTextAge;
    Button ButtonBMRCalc;


    public BMRFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View MainView = inflater.inflate(R.layout.fragment_bmr2, container, false);

        TextViewResult = MainView.findViewById(R.id.textViewBMRresult);
        EditTextHeight = MainView.findViewById(R.id.editTextHeightBMR);
        EditTextWeight = MainView.findViewById(R.id.editTextWeightBMR);
        EditTextAge = MainView.findViewById(R.id.editTextAgeBMR);
        CheckBoxMale = MainView.findViewById(R.id.checkBoxMale);
        CheckBoxFemale = MainView.findViewById(R.id.checkBoxFemale);
        ButtonBMRCalc = MainView.findViewById(R.id.buttonBMRcalc);


        if(CheckBoxMale.isChecked()){
            CheckBoxFemale.setActivated(false);
        }
        else if(CheckBoxFemale.isChecked()){
            CheckBoxMale.setActivated(false);
        }

        ButtonBMRCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DecimalFormat df = new DecimalFormat("####.#");
                String Height = EditTextHeight.getText().toString();
                String Weight = EditTextWeight.getText().toString();
                String Age = EditTextAge.getText().toString();

                if(!Height.isEmpty() && !Weight.isEmpty() && !Age.isEmpty()){

                    double height = Double.parseDouble(Height);
                    double weight = Double.parseDouble(Weight);
                    double age = Double.parseDouble(Age);


                    if(CheckBoxMale.isChecked()){
                        double calculate = 655 + (9.6 * weight) + (1.8 * height) - (4.7 * age);
                        String result= df.format(calculate);

                        TextViewResult.setText("BMR = "+result);

                    }
                    else if(CheckBoxFemale.isChecked()){
                        double calculate = 66 + (13.7 * weight) + (5 * height) - (6.4 * age);
                        String result = df.format(calculate);

                        TextViewResult.setText("BMR = "+result);

                    }

                } else{
                    Toast.makeText(getActivity(), "উচ্চতা, ওজন আর বয়স লিখুন", Toast.LENGTH_SHORT).show();
                }






            }
        });



        return MainView;
    }

}
