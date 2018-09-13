package com.olczyk.android.startactivityforresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView textViewResult;
    private EditText editTextOne;
    private EditText editTextTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = findViewById(R.id.text_view_result);
        editTextOne = findViewById(R.id.editText);
        editTextTwo = findViewById(R.id.editText2);


        Button openActivityTwo = findViewById(R.id.button_open_activity_2);
        openActivityTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editTextOne.getText().toString().equals("")
                        || editTextTwo.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "please insert numbers",
                            Toast.LENGTH_SHORT).show();
                } else {
                    int number1 = Integer.parseInt(editTextOne.getText().toString());
                    int number2 = Integer.parseInt(editTextTwo.getText().toString());

                    Intent intent = new Intent(MainActivity.this,
                            Activity2.class);
                    intent.putExtra("number1",number1);
                    intent.putExtra("number2",number2);
                    startActivityForResult(intent,1);
                }


            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1){
            if(resultCode == RESULT_OK){
                int result = data.getIntExtra("result",0);
                textViewResult.setText("" + result);
            }
            if(resultCode == RESULT_CANCELED){
                Toast.makeText(this, "intent was empty",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
