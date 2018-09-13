package com.olczyk.android.startactivityforresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        setTitle("Activity2");

        Intent intent = getIntent();
        final int numer1 = intent.getIntExtra("number1",0);
        final int numer2 = intent.getIntExtra("number2",0);

        TextView textViewNumbers = findViewById(R.id.text_view_numbers);
        textViewNumbers.setText("Numbers: " + numer1 + ", " + numer2);

        Button add = findViewById(R.id.button_add);
        Button substract = findViewById(R.id.button_substract);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int result = numer1 + numer2;

                Intent intentResult = new Intent(Activity2.this,
                        MainActivity.class);
                intentResult.putExtra("result",result);
                setResult(RESULT_OK,intentResult);
                finish();
            }
        });

        substract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int substract =numer1 - numer2;

                Intent intentResult = new Intent(Activity2.this,
                        MainActivity.class);
                intentResult.putExtra("result",substract);
                setResult(RESULT_OK,intentResult);
                finish();

            }
        });
    }
}
