package com.example.mycalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    EditText et;
    Button b[] = new Button[20];


    int id[] = {R.id.btAc,R.id.btBack,R.id.btMod,R.id.btDiv,
                R.id.bt7,R.id.bt8,R.id.bt9,R.id.btMult,
                R.id.bt4,R.id.bt5,R.id.bt6,R.id.btSub,
                R.id.bt1,R.id.bt2,R.id.bt3,R.id.btAdd,
                R.id.btPar,R.id.bt0,R.id.btDot,R.id.btEqual};
    String number="";

    int par=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = findViewById(R.id.et);
        try {
            for (int i = 0; i < b.length; i++) {
                b[i] = findViewById(id[i]);
                b[i].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Button bt = (Button) v;
                        String label = bt.getText().toString();
                        String temp = ".0123456789+-÷×%";

                        if (temp.indexOf(label) != -1)
                        {
                            if (label.equals(".") && number.equals(""))
                            {
                                number += "0.";
                            }
                            else
                            {
                                number += label;
                            }
                            et.setText(number);
                        }
                        else if(label.equals("()"))
                        {
                            String temp1="+-÷×%(";
                            if(par==0)
                            {
                                number+="(";
                                par++;
                            }
                            else if(temp1.indexOf(number.charAt(number.length()-1))!=-1)
                            {
                                number+="(";
                                par++;
                            }
                            else if(par>0)
                            {
                                number+=")";
                                par--;
                            }
                            et.setText(number);
                        }
                        else if (label.equals("AC"))
                        {
                            number = "";
                            par=0;
                            et.setText("0");
                        }
                        else if (label.equals("BACK"))
                        {
                            if (number.length() > 1)
                            {
                                if (number.equalsIgnoreCase("Infinity") || number.equalsIgnoreCase("NaN"))
                                {
                                    number = "";
                                    et.setText("0");
                                }
                                else
                                {
                                    if(number.charAt(number.length()-1)==')')
                                    {
                                        par++;
                                    } else if (number.charAt(number.length()-1)=='(')
                                    {
                                        par--;
                                    }
                                    number = number.substring(0, number.length() - 1);
                                    et.setText(number);
                                }
                            }
                            else
                            {
                                par=0;
                                et.setText("0");
                                number = "";
                            }
                        }
                        else if (label.equals("="))
                        {
                            if(par!=0)
                            {
                                Toast.makeText(getApplicationContext(),"Invalid Expression",Toast.LENGTH_SHORT).show();
                            }
                            else
                            {

                                String input = et.getText().toString();
                                Evaluation1 e = new Evaluation1(input);
                                if (e.rank == 1)
                                {
                                    number = "" + e.postfixEvaluation();
                                    et.setText(number);
                                }
                                else
                                {
                                    Toast.makeText(getApplicationContext(),"Invalid Expression",Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    }
                });
            }
        }
        catch (Exception ex)
        {
            Toast.makeText(getApplicationContext(),"Invalid Expression",Toast.LENGTH_SHORT).show();
        }
    }
}