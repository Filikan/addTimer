package com.example.addtimer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvTotal;
    EditText etH,etM,etS;
    Button btn;
    int totalh = 0,totalm = 0,totals = 0;
    int hour,minute,second;
    String total = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTotal = (TextView) findViewById(R.id.tvTotal);
        etH = (EditText) findViewById(R.id.etH);
        etM = (EditText) findViewById(R.id.etM);
        etS = (EditText) findViewById(R.id.etS);
    }

    public void Click(View v){
        hour = Integer.valueOf(etH.getText().toString());
        minute = Integer.valueOf(etM.getText().toString());
        second = Integer.valueOf(etS.getText().toString());

        totalh = totalh + hour;
        totalm = totalm + minute;
        totals = totals + second;

        if (totals >= 60)
        {
//          totals = (totals%60) + totals;
            totals = totals - 60;
            totalm = totalm + 1;
        }
        if (totalm >= 60)
        {
            totalm = totalm - 60;
            totalh = totalh + 1;
        }

        tvTotal.setText("Total: " + totalh + " h " + totalm + " m " + totals + " s ");
        //tvTotal.setText(""+totalh + "boş" + totalm + "boş" + totals);
        etH.setText("0");
        etM.setText("0");
        etS.setText("0");
    }

    public void Clear(View v){
        tvTotal.setText("");

        totalh = 0;
        totalm = 0;
        totals = 0;

        tvTotal.setText("Total: " + totalh + " h " + totalm + " m " + totals + " s ");

    }
}