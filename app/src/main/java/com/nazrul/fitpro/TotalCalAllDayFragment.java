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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;


/**
 * A simple {@link Fragment} subclass.
 */
public class TotalCalAllDayFragment extends Fragment {

    TextView DailyTotalCalNeed;
    CheckBox WorkType1, WorkType2, WorkType3, WorkType4, WorkType5;
    Button CalcDailyCal;
    EditText EditTextGiveBMR;

    public TotalCalAllDayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View MainView = inflater.inflate(R.layout.fragment_total_cal_all_day, container, false);

        DailyTotalCalNeed = MainView.findViewById(R.id.textViewDaillCalNeed);
        WorkType1 = MainView.findViewById(R.id.checkBoxWork1);
        WorkType2 = MainView.findViewById(R.id.checkBoxWork2);
        WorkType3 = MainView.findViewById(R.id.checkBoxWork3);
        WorkType4 = MainView.findViewById(R.id.checkBoxWork4);
        WorkType5 = MainView.findViewById(R.id.checkBoxWork5);
        CalcDailyCal = MainView.findViewById(R.id.buttonDailyCal);
        EditTextGiveBMR = MainView.findViewById(R.id.editTextEnterBMR);




        CalcDailyCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double calculate;
                DecimalFormat df = new DecimalFormat("####.#");


                if(WorkType1.isChecked()){

                    String BMR = EditTextGiveBMR.getText().toString();
                    Double bmr = Double.parseDouble(BMR);
                    String result;
                    calculate = bmr * 1.2;

                    result = df.format(calculate);

                    DailyTotalCalNeed.setText("আপনার প্রতিদিন " + result + " ক্যালরি শক্তি দরকার");
                }
                else if(WorkType2.isChecked()){
                    String BMR = EditTextGiveBMR.getText().toString();
                    Double bmr = Double.parseDouble(BMR);
                    String result;
                    calculate = bmr * 1.375;

                    result = df.format(calculate);

                    DailyTotalCalNeed.setText("আপনার প্রতিদিন " + result + " ক্যালরি শক্তি দরকার");

                }
                else if(WorkType3.isChecked()){
                    String BMR = EditTextGiveBMR.getText().toString();
                    Double bmr = Double.parseDouble(BMR);
                    String result;
                    calculate = bmr * 1.55;

                    result = df.format(calculate);

                    DailyTotalCalNeed.setText("আপনার প্রতিদিন " + result + " ক্যালরি শক্তি দরকার");
                }
                else if(WorkType4.isChecked()){
                    String BMR = EditTextGiveBMR.getText().toString();
                    Double bmr = Double.parseDouble(BMR);
                    String result;
                    calculate = bmr * 1.725;

                    result = df.format(calculate);

                    DailyTotalCalNeed.setText("আপনার প্রতিদিন " + result + " ক্যালরি শক্তি দরকার");
                }
                else if(WorkType5.isChecked()){
                    String BMR = EditTextGiveBMR.getText().toString();
                    Double bmr = Double.parseDouble(BMR);
                    String result;
                    calculate = bmr * 1.9;

                    result = df.format(calculate);

                    DailyTotalCalNeed.setText("আপনার প্রতিদিন " + result + " ক্যালরি শক্তি দরকার");
                }
                else{
                    Toast.makeText(getActivity(), "আগে কাজের ধরণ বাছাই করুন", Toast.LENGTH_SHORT).show();
                }
            }
        });




        return MainView;
    }

}
