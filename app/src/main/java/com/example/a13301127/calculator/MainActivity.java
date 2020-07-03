package com.example.a13301127.calculator;

import android.os.Bundle;
import android.app.Activity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

    EditText etNum1;
    EditText etNum2;

    Button btnAdd;
    Button btnSub;
    Button btnMult;
    Button btnDiv;

    TextView tvResult;

    String oper = "";

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // find the elements
        etNum1 = (EditText) findViewById(R.id.etNum1);
        etNum2 = (EditText) findViewById(R.id.etNum2);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnMult = (Button) findViewById(R.id.btnMult);
        btnDiv = (Button) findViewById(R.id.btnDiv);

        tvResult = (TextView) findViewById(R.id.tvResult);

        // set a listener
        btnAdd.setOnClickListener((OnClickListener) this);
        btnSub.setOnClickListener(this);
        btnMult.setOnClickListener(this);
        btnDiv.setOnClickListener(this);

    }

    @Override
    public static void onClick(MainActivity mainActivity, View v) {
        // TODO Auto-generated method stub
        float num1 = 0;
        float num2 = 0;
        float result = 0;

        // check if the fields are empty
        if (TextUtils.isEmpty(mainActivity.etNum1.getText().toString())
                || TextUtils.isEmpty(mainActivity.etNum2.getText().toString())) {
            return;
        }

        // read EditText and fill variables with numbers
        num1 = Float.parseFloat(mainActivity.etNum1.getText().toString());
        num2 = Float.parseFloat(mainActivity.etNum2.getText().toString());

        // defines the button that has been clicked and performs the corresponding operation
        // write operation into oper, we will use it later for output
        switch (v.getId()) {
            case R.id.btnAdd:
                mainActivity.oper = "+";
                result = num1 + num2;
                break;
            case R.id.btnSub:
                mainActivity.oper = "-";
                result = num1 - num2;
                break;
            case R.id.btnMult:
                mainActivity.oper = "*";
                result = num1 * num2;
                break;
            case R.id.btnDiv:
                mainActivity.oper = "/";
                result = num1 / num2;
                break;
            default:
                break;
        }

        // form the output line
        mainActivity.tvResult.setText(num1 + " " + mainActivity.oper + " " + num2 + " = " + result);
    }
}