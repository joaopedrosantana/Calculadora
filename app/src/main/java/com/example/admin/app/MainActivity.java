package com.example.admin.app;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.*;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    private EditText value1, value2;
    private Button btnOper, btnLimp;
    private TextView result;
    double firstValue, secondValue, resultOper;

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        value1 = (EditText) findViewById(R.id.input_first_value);
        value2 = (EditText) findViewById(R.id.input_second_value);
        btnOper = (Button) findViewById(R.id.btn_operation);
        result = (TextView) findViewById(R.id.result_operation);
        btnLimp = (Button) findViewById(R.id.btn_limp);



        btnLimp.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           result.setText("");

                                       }
                                   });



        btnOper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                RadioGroup rg = (RadioGroup) findViewById(R.id.r_group);
                int verifyRadio = rg.getCheckedRadioButtonId();


                if (value1.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Os campos são obrigatórios", Toast.LENGTH_LONG).show();
                } else {
                    if (value2.getText().toString().isEmpty()) {
                        Toast.makeText(MainActivity.this, "Os campos são obrigatórios", Toast.LENGTH_LONG).show();
                    } else {
                        if (verifyRadio == -1) {
                            Toast.makeText(MainActivity.this, "Os campos são obrigatórios", Toast.LENGTH_LONG).show();
                        } else {

                            firstValue = Double.parseDouble(value1.getText().toString());
                            secondValue = Double.parseDouble(value2.getText().toString());
                            switch (verifyRadio) {


                                case R.id.soma: {
                                    resultOper = firstValue + secondValue;
                                    break;
                                }
                                case R.id.sub: {
                                    resultOper = firstValue - secondValue;
                                    break;
                                }
                                case R.id.mult: {
                                    resultOper = firstValue * secondValue;
                                    break;
                                }
                                case R.id.div: {
                                    if (secondValue == 0) {
                                        Toast.makeText(MainActivity.this, "Não é possível dividir por zero", Toast.LENGTH_LONG).show();
                                    } else {
                                        resultOper = firstValue / secondValue;
                                    }
                                    break;
                                }
                                case R.id.porcent: {
                                    resultOper = (firstValue * secondValue) / 100;
                                }

                            }

                        }


                        if (resultOper == 0) {

                        } else {
                            if ((resultOper == Math.floor(resultOper)) && !Double.isInfinite(resultOper)) {
                                int resultInt = (int) (resultOper);
                                String valueString = String.valueOf(resultInt);
                                result.setText(valueString);
                            } else {
                                String[] breakNum = String.valueOf(resultOper).split("\\.");
                                if (breakNum[1].length() > 4) {

                                    double valueDouble = resultOper;
                                    String valueString = String.valueOf(round(valueDouble, 3));
                                    result.setText(valueString + "...");
                                } else {
                                    float resultDeck = (float) (resultOper);
                                    String resultFloat = Float.toString(resultDeck);
                                    result.setText(resultFloat);

                                }


                            }


                        }
                    }




                }
            }


        });
        value1.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {


                if(start>=12)
                {
                    String textString = String.valueOf(s) ;
                    Toast.makeText(MainActivity.this,"Limite de caracteres atingido", Toast.LENGTH_LONG).show();
                    //value2.getText().delete(start -1, start );
                    value1.setText(textString.substring(0, textString.length() - 1 ));
                    value1.setSelection(value1.getText().length());

                }

            }

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {

            }

            public void afterTextChanged(Editable s) {

            }
        });
        value2.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {


                if(start>=12)
                {
                    String textString = String.valueOf(s) ;
                    Toast.makeText(MainActivity.this,"Limite de caracteres atingido", Toast.LENGTH_LONG).show();
                    //value2.getText().delete(start -1, start );
                    value2.setText(textString.substring(0, textString.length() - 1 ));
                    value2.setSelection(value2.getText().length());

                }


            }

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {

            }

            public void afterTextChanged(Editable s) {

            }
        });
    }

}
