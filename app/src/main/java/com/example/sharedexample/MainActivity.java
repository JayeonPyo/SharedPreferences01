package com.example.sharedexample;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et_save;
    String shared = "file";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_save = (EditText)findViewById(R.id.et_save);


        SharedPreferences sharedPreferences = getSharedPreferences(shared,0);
        String value = sharedPreferences.getString("jayeon","");
        et_save.setText(value);


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();


        SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String value = et_save.getText().toString();
        editor.putString("jayeon",value);
        editor.commit(); //저장완료

    }
}
