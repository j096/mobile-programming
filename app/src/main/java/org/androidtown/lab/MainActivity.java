package org.androidtown.lab;


import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.app.Activity;
import android.graphics.Color;
import android.view.ContextMenu;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class MainActivity extends AppCompatActivity {


    Button button1;
    EditText ed;
    RadioGroup radGroupMW;
    RadioButton M;
    RadioButton W;
    CheckBox cb1;
    CheckBox cb2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1=(Button)findViewById(R.id.button1);
        ed=(EditText)findViewById(R.id.nameline);
        radGroupMW=(RadioGroup)findViewById(R.id.radGroupMW);
        M=(RadioButton) findViewById(R.id.M);
        W=(RadioButton)findViewById(R.id.W);
        cb1=(CheckBox)findViewById(R.id.sms);
        cb2=(CheckBox)findViewById(R.id.email);


        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),NewActivity.class);

                String name=ed.getText().toString();
                String check = ":";
                int radioId=radGroupMW.getCheckedRadioButtonId();

                if(M.getId()==radioId)
                    i.putExtra("MW","남");

                if(W.getId()==radioId)
                    i.putExtra("MW","여");

                if(cb1.isChecked()) {
                    check += "SMS";
                    i.putExtra("check", check);
                }
                if(cb2.isChecked()) {
                    check+="e-mail";
                    i.putExtra("check", check);
                }

                i.putExtra("name",name);
                startActivity(i);

            }
        });
    }



}
