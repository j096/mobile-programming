package org.androidtown.lab;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    RelativeLayout layout1;
    RelativeLayout layout2;
    int c1=0,c2=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout1=(RelativeLayout)findViewById(R.id.m1);
        layout2=(RelativeLayout)findViewById(R.id.m2);



        layout1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                c1++;
                if (c1 % 2 == 0) {
                    killMediaPlayer();
                    Toast.makeText(getApplicationContext(), "음악 파일 멈춤1", Toast.LENGTH_LONG).show();
                }

                else{
                    String tag1 = (String) layout1.getTag();
                    int id_audio1 = getResources().getIdentifier(tag1, "raw", getPackageName());
                    try {
                        playAudio(id_audio1);
                        Toast.makeText(getApplicationContext(), "음악 파일 재생1", Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        layout2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                c2++;
                if(c2%2==0) {
                    killMediaPlayer();
                    Toast.makeText(getApplicationContext(), "음악 파일 멈춤2", Toast.LENGTH_LONG).show();
                }

                else {
                    String tag2 = (String) layout2.getTag();
                    int id_audio2 = getResources().getIdentifier(tag2, "raw", getPackageName());
                    try {
                        playAudio(id_audio2);
                        Toast.makeText(getApplicationContext(), "음악 파일 재생2", Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }




    private void playAudio(int id)throws Exception{
        killMediaPlayer();
        mediaPlayer=MediaPlayer.create(this,id);
        mediaPlayer.start();
    }

    private void killMediaPlayer(){
        if(mediaPlayer!=null){
            try{
                mediaPlayer.release();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}












