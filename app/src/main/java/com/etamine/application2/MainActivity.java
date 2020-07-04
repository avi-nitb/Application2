package com.etamine.application2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    char operation;
    int a, b, result;
    String action;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle bundle = getIntent().getBundleExtra("inputParameters");
        if (bundle != null) {
            a = bundle.getInt("FirstParameter");
            b = bundle.getInt("SecondParameter");
            operation = bundle.getChar("Operation");
        }

        if (operation == '+') {
            //Perform addition
            result = a + b;
            action = "addition";
        } else if (operation == '-'){
            //Perform Subtraction
            result = a - b;
            action = "subtraction";
        }

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_ATTACH_DATA);
        intent.setClassName("com.etamine.application1", "com.etamine.application1.MainActivity");
        intent.putExtra("Result", result);
        intent.putExtra("FirstParameter", a);
        intent.putExtra("SecondParameter", b);
        intent.putExtra("Action", action);
        startActivity(intent);

    }
}
