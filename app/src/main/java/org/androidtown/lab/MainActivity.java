package org.androidtown.lab;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    Button b1;
    Button b2;
    Button b3;
    Button b4;
    EditText et;
    String text;
    String note="text.txt";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et=(EditText)findViewById(R.id.editText);
        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);
        b4=(Button)findViewById(R.id.button4);



        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){


                text=et.getText().toString();
                File sd= Environment.getExternalStorageDirectory();
                File directory=new File(sd.getAbsolutePath()+"/MyFiles");

                directory.mkdirs();
                File file=new File(directory+"/"+note);
                try {
                    FileOutputStream fOut=new FileOutputStream(file);
                    OutputStreamWriter osw=new OutputStreamWriter(fOut);
                    osw.write(text);
                    osw.close();
                    fOut.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        });

        b2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                et.setText("");
            }
        });

        b3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                File sd=Environment.getExternalStorageDirectory();
                File directory=new File(sd.getAbsolutePath()+"/MyFiles");

                directory.mkdirs();
                File file=new File(directory,note);
                try {
                    FileInputStream fIn = new FileInputStream(file);
                    InputStreamReader isr=new InputStreamReader(fIn);



                    if(fIn!=null){
                        BufferedReader reader=new BufferedReader(isr);
                        String str="";
                        StringBuffer buf=new StringBuffer();

                        while((str=reader.readLine())!=null){
                            buf.append(str+"\n");
                        }
                        et.setText(buf.toString());

                        isr.close();
                        fIn.close();

                    }

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        });


        b4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
            }
        });


    }

}






