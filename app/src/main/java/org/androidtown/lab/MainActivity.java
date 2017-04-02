package org.androidtown.lab;

import android.app.SearchManager;
import android.content.Context;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.content.Intent;
import android.widget.Toast;




public class MainActivity extends AppCompatActivity {


    EditText Age;
    EditText Name;
    Button button1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Name=(EditText)findViewById(R.id.editText1);
        Age=(EditText)findViewById(R.id.editText2);
        button1=(Button)findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String n=Name.getText().toString();
                String a=Age.getText().toString();
                Intent intent=new Intent(getApplicationContext(),NewActivity.class);
                intent.putExtra("name",n);
                intent.putExtra("age",a);
                startActivity(intent);
            }
        });






    }


}
