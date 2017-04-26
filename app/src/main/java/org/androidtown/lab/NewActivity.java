package org.androidtown.lab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.data;

public class NewActivity extends AppCompatActivity {


    TextView tv1;
    TextView tv2;
    TextView tv3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        tv1=(TextView)findViewById(R.id.nameline);
        tv2=(TextView)findViewById(R.id.mwline);
        tv3=(TextView)findViewById(R.id.sendline);


        Intent passedIntent = getIntent();

        if(passedIntent!=null){


            String name=passedIntent.getStringExtra("name");
            String MW=passedIntent.getStringExtra("MW");
            String send=passedIntent.getStringExtra("check");

            tv1.setText(":"+name);
            tv2.setText(":"+MW);
            tv3.setText(send);
        }

        Button button=(Button)findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                finish();
            }
        });
    }
}
