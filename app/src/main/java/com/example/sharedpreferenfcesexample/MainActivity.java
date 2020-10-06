package com.example.sharedpreferenfcesexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private EditText editText;
    private Button applyButtom;
    private Button saveButton;
    private Switch aSwitch;

    public static final String SHARED_PREDS ="sharedPrefs";
    public static final String TEXT ="text";
    public static final String SWITCH1="switch1";

    private String text;
    private Boolean switchOnOff;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.textView);
        editText=findViewById(R.id.editTextTextPersonName);
        applyButtom=findViewById(R.id.button);
        saveButton=findViewById(R.id.button2);
        aSwitch=findViewById(R.id.switch1);

        applyButtom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(editText.getText().toString());
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
            }
        });

        loadData();
        upDateViews();


    }

    private void saveData() {

        SharedPreferences sharedPreferences=getSharedPreferences(SHARED_PREDS,MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(TEXT,editText.getText().toString());
        editor.putBoolean(SWITCH1,aSwitch.isChecked());
        editor.apply();
        Toast.makeText(this,"Saved",Toast.LENGTH_SHORT).show();



    }

    private void loadData()
    {
        SharedPreferences sharedPreferences=getSharedPreferences(SHARED_PREDS,MODE_PRIVATE);
        text=sharedPreferences.getString(TEXT,"");
        switchOnOff=sharedPreferences.getBoolean(SWITCH1,false);

    }
    private void upDateViews()
    {
        textView.setText(text);
        aSwitch.setChecked(switchOnOff);
    }
}