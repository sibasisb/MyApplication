package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onModeChange(View view) {
        String ch;
        Button button=findViewById(R.id.b_mode);
        ch=button.getText().toString();
        String p="";
        switch(ch){
            case "MODE": p = "ADDITION";
                         break;
            case "SUBTRACTION":p="PRODUCT";
                                break;
            case "ADDITION":p="SUBTRACTION";
                            break;
            case "PRODUCT":p="DIVIDE";
                            break;
            case "DIVIDE": p="MODE";
                            break;
        }


        button.setText(p);
    }

    public void findResult(View view) {
        Button button=findViewById(R.id.b_mode);
        String ch;
        double res=0.0;
        ch=button.getText().toString();
        double num1=0.0,num2=0.0;
        EditText et_field_1=findViewById(R.id.editText2);
        EditText et_field_2=findViewById(R.id.editText);
        String s1=et_field_1.getText().toString();
        String s2=et_field_2.getText().toString();
        if(s1.equals("")||s2.equals(""))
        {
            Toast.makeText(this, "Enter operand", Toast.LENGTH_SHORT).show();
            return;
        }
        num1=Double.parseDouble(s1);
        num2=Double.parseDouble(s2);
        TextView ed_res=findViewById(R.id.editText3);
        ed_res.setInputType(InputType.TYPE_NULL);

        switch(ch){
            case "MODE":Toast.makeText(this, "Choose a mode of operation", Toast.LENGTH_SHORT).show();
                        break;
            case "ADDITION":res=num1+num2;
                            break;
            case "SUBTRACTION":res=num1-num2;
                                break;
            case "PRODUCT":res=num1 * num2;
                                break;
            case "DIVIDE":      if(num2==0) {

                Toast.makeText(this, "You can't divide with 0", Toast.LENGTH_SHORT).show();
                return;
            }
                                res = num1 / num2;
                                break;
             default:res=0.0;
        }

        ed_res.setText(String.valueOf(res));


    }
}
