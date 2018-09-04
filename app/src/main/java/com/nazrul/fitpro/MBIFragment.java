package com.nazrul.fitpro;
/**Title: Fitapp
 * Author: Md. Nazrul Islam
 *
 */


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DecimalFormat;


/**
 * A simple {@link Fragment} subclass.
 */
public class MBIFragment extends Fragment {

    TextView ViewResult, ViewDescription;
    EditText EditTextHeight, EditTextWeight;
    Button ButtonCalculate;

    public MBIFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View MainView = inflater.inflate(R.layout.fragment_mbi, container, false);


        ViewResult = MainView.findViewById(R.id.textViewResult);
        ViewDescription = MainView.findViewById(R.id.textViewDes);
        EditTextHeight = MainView.findViewById(R.id.editTextHeight);
        EditTextWeight = MainView.findViewById(R.id.editTextWeight);
        ButtonCalculate = MainView.findViewById(R.id.buttonCalcBMI);


        ButtonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Height, Weight;

                Height = EditTextHeight.getText().toString();
                Weight = EditTextWeight.getText().toString();
                double calculation = 0;

                if(!Height.isEmpty() && !Weight.isEmpty()){

                    DecimalFormat df = new DecimalFormat("##.#");
                    double height = Double.parseDouble(Height);
                    double weight = Double.parseDouble(Weight);
                    calculation = weight/Math.pow(height/100,2);
                    double temp = calculation;
                    String result = df.format(temp);
                    ViewResult.setText("BMI = "+result);

                } else{
                    Toast.makeText(getActivity(), "বয়স আর উচ্চতা লিখুন", Toast.LENGTH_SHORT).show();
                }


                //I don't know why the fuck these code not working.
                if(calculation < 18.5) {
                    ViewDescription.setText("আপনার BMI Case 1");
                    //ViewDescription.setText(R.string.textViewDesCase1);
                } else if( calculation >= 18.5 && calculation <= 24.9) {
                    ViewDescription.setText("আপনার BMI Case 2");
                    //ViewDescription.setText(R.string.textViewDesCase2);
                } else if( calculation >= 25 && calculation <= 29.9){
                    ViewDescription.setText("আপনার BMI Case 3");
                    //ViewDescription.setText(R.string.textViewDesCase3);
                }
                else if( calculation >= 30 && calculation <= 34.9){
                    ViewDescription.setText("আপনার BMI Case 4");
                    //ViewDescription.setText(R.string.textViewDesCase4);
                }
                else if( calculation >= 35 && calculation <= 39.9){
                    ViewDescription.setText("আপনার BMI Case 5");
                    //ViewDescription.setText(R.string.textViewDesCase5);
                }
                else if( calculation >= 40){
                    ViewDescription.setText("আপনার BMI case 6");
                    //ViewDescription.setText(R.string.textViewDesCase6);
                }
                else{
                    ViewDescription.setText("No Case");
                }
            }
        });

        return MainView; //inflater.inflate(R.layout.fragment_mbi, container, false);
    }



}
