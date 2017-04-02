package org.androidtown.lab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.R.attr.data;

public class NewActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        Intent passedIntent = getIntent();

        if(passedIntent!=null){


            String outName=passedIntent.getStringExtra("name");
            String outAge=passedIntent.getStringExtra("age");

            Toast.makeText(getApplicationContext(),"Student Info "+outName+" "+outAge,Toast.LENGTH_LONG).show();


        }

        Button button=(Button)findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                finish();
            }
        });
    }
}
