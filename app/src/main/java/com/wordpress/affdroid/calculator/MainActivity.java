package com.wordpress.affdroid.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView n, result;
    Button b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bdot, bplus, bdiv, bmult, bmin, beq, bclear;

    float a = 0, b = 0, r = 0;
    String fl;

    ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setElevation(0);

        n = (TextView) findViewById(R.id.n);
        result = (TextView) findViewById(R.id.result);

//        n.setFocusable(false);


        b0 = (Button) findViewById(R.id.btn_0);
        b1 = (Button) findViewById(R.id.btn_1);
        b2 = (Button) findViewById(R.id.btn_2);
        b3 = (Button) findViewById(R.id.btn_3);
        b4 = (Button) findViewById(R.id.btn_4);
        b5 = (Button) findViewById(R.id.btn_5);
        b6 = (Button) findViewById(R.id.btn_6);
        b7 = (Button) findViewById(R.id.btn_7);
        b8 = (Button) findViewById(R.id.btn_8);
        b9 = (Button) findViewById(R.id.btn_9);

        bdot = (Button) findViewById(R.id.btn_dot);

        bplus = (Button) findViewById(R.id.btn_plus);
        bmin = (Button) findViewById(R.id.btn_minus);
        bdiv = (Button) findViewById(R.id.btn_div);
        bmult = (Button) findViewById(R.id.btn_mult);

        beq = (Button) findViewById(R.id.btn_eql);
        bclear = (Button) findViewById(R.id.btn_clear);

        scrollView = (ScrollView) findViewById(R.id.scrollView);

        b0.setOnClickListener(this);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);

        bdot.setOnClickListener(this);

        bmult.setOnClickListener(this);
        bplus.setOnClickListener(this);
        bmin.setOnClickListener(this);
        bdiv.setOnClickListener(this);

        beq.setOnClickListener(this);
        bclear.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (n.length() != 9) {


            if (v == b0) {
                if (!n.getText().toString().equals(""))
                    n.setText(n.getText().toString() + 0);
            }
            if (v == b1)
                n.setText(n.getText().toString() + 1);
            if (v == b2)
                n.setText(n.getText().toString() + 2);
            if (v == b3)
                n.setText(n.getText().toString() + 3);
            if (v == b4)
                n.setText(n.getText().toString() + 4);
            if (v == b5)
                n.setText(n.getText().toString() + 5);
            if (v == b6)
                n.setText(n.getText().toString() + 6);
            if (v == b7)
                n.setText(n.getText().toString() + 7);
            if (v == b8)
                n.setText(n.getText().toString() + 8);
            if (v == b9)
                n.setText(n.getText().toString() + 9);
            if (v == bdot) {
                if (!n.getText().toString().contains("."))
                    n.setText(n.getText().toString() + ".");
            }
        }
        if (v == bclear) {
            n.setText("");
            result.setText("");
        }

        if (n.length() != 0) {

            if (v == bplus) {
                a = Float.parseFloat(n.getText().toString());
                fl = "plus";
                n.setText("");
                result.setText(result.getText().toString()+"\n"+NumberFormat.getInstance().format(a) + " +");
            }
            if (v == bmin) {
                a = Float.parseFloat(n.getText().toString());
                fl = "minus";
                n.setText("");
                result.setText(result.getText().toString()+"\n"+NumberFormat.getInstance().format(a) + " -");
            }
            if (v == bmult) {
                a = Float.parseFloat(n.getText().toString());
                fl = "mult";
                n.setText("");
                result.setText(result.getText().toString()+"\n"+NumberFormat.getInstance().format(a) + " x");
            }
            if (v == bdiv) {
                a = Float.parseFloat(n.getText().toString());
                fl = "div";
                n.setText("");
                result.setText(result.getText().toString()+"\n"+NumberFormat.getInstance().format(a) + " /");
            }
            if (v == beq) {
                if (a != 0) {
                    b = Float.parseFloat(n.getText().toString());
                    switch (fl) {
                        case "plus":
                            r = a + b;
                            break;
                        case "minus":
                            r = a - b;
                            break;
                        case "mult":
                            r = a * b;
                            break;
                        case "div":
                            if (b == 0)
                                Toast.makeText(getApplicationContext(), "Division by zero", Toast.LENGTH_SHORT).show();
                            else
                                r = a / b;
                    }
                    n.setText("" + r);
                    result.setText(result.getText().toString() + " " + NumberFormat.getInstance().format(b) + " = " + NumberFormat.getInstance().format(r));
                    scrollView.fullScroll(View.FOCUS_DOWN);
                    a = 0;
                    b = 0;
                    r = 0;
                }
            }

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.me,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.calc)
            Toast.makeText(MainActivity.this, "Designed & Developed by \n\n Afinas E M\n affdroid.wordpress.com", Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }
}
