package com.rafsan.class216electricitybill;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button buttonCalculate;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        buttonCalculate = findViewById(R.id.buttonCalculate);
        textView = findViewById(R.id.textView);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String string_unites = editText.getText().toString();

                float bill = 0, totalBill;
                int demand_charge = 15;
                int service_charge = 30;

                if(string_unites.length() > 0){

                    float float_units = Float.parseFloat(string_unites);

                    if(float_units <= 75){
                        bill = (float) (float_units * 4.19);

                    } else if ( float_units > 75 && float_units <= 200) {
                        bill = (float) (314.25 + ((float_units-75) * 5.72));

                    } else if ( float_units >200 && float_units <= 300) {

                        bill = (float) (314.25+715 + ((float_units-200)*6.00));

                    } else if ( float_units > 300 && float_units <= 400) {

                        bill = (float) (314.25+715+600 + ((float_units-300)*6.34));

                    }
                    else {
                        bill = (float) (314.25+715+600+634 + ((float_units-400)*9.94));
                    }

                }
                else {

                    textView.setText("Please, Enter Your Unites");
                }

                totalBill = bill + demand_charge +service_charge;

                textView.setText("Your Electric bill is = "+ totalBill);



            }
        });

    }
}