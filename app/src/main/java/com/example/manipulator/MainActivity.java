package com.example.manipulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static StringBuffer sb = new StringBuffer();
    private static int textSize = 12;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonRegister();
    }

    private View.OnClickListener buttonListener = new View.OnClickListener() {
        public void onClick(View v) {
            Button button = (Button) v;
            TextView textView = (TextView) viewObj("display");
            EditText editText = (EditText) viewObj("textInput");
            String buttonValue = button.getText().toString();

            if (buttonValue.equals("COPY")) sb.append(editText.getText().toString());
            else if (buttonValue.equals("DOUBLE")) sb.append(sb);
            else if (buttonValue.equals("UP")) textView.setTextSize(textSize++);
            else textView.setTextSize(textSize--);
            display(textView);


        }
    };

    private View viewObj(String sID){
        int ID = getResources().getIdentifier(sID, "id", getPackageName());
        return findViewById(ID);
    }

    private void display(TextView textView){
        textView.setText(sb.toString());
    }

    private void buttonRegister(){
        for (int i=1; i<=4; i++){
            Button button = (Button) viewObj("B-"+i);
            button.setOnClickListener(buttonListener);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(MainActivity.this, R.string.welcome, Toast.LENGTH_LONG).show();
    }
}
