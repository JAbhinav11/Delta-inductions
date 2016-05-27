package com.example.abhinav.delta01a;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    RelativeLayout rel1;
    TextView tv1;
    Button btn1,reset;
    int count=0;
    int randcolor=Color.WHITE;
    SharedPreferences pref1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rel1=(RelativeLayout)findViewById(R.id.RelativeLayout1);
        tv1=(TextView)findViewById(R.id.textView1);
        btn1=(Button)findViewById(R.id.button1);
        reset=(Button)findViewById(R.id.reset);

        pref1=getSharedPreferences("cntclr",Context.MODE_PRIVATE);

        count=pref1.getInt("count1",0);
        randcolor=pref1.getInt("randcolor1",Color.WHITE);
        tv1.setText(Integer.toString(count));
        rel1.setBackgroundColor(randcolor);

    /*    if(savedInstanceState!=null){
            count=savedInstanceState.getInt("count");
            randcolor=savedInstanceState.getInt("randcolor");
            tv1.setText(Integer.toString(count));
            rel1.setBackgroundColor(randcolor);
        }   */

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                tv1.setText(Integer.toString(count));
                Random rand=new Random();
                randcolor= Color.rgb(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255));
                rel1.setBackgroundColor(randcolor);

                SharedPreferences.Editor edt1 = pref1.edit();
                edt1.putInt("count1", count);
                edt1.putInt("randcolor1", randcolor);
                edt1.commit();
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count=0;
                tv1.setText(Integer.toString(count));
                randcolor=Color.WHITE;
                rel1.setBackgroundColor(randcolor);

                SharedPreferences.Editor edt1 = pref1.edit();
                edt1.putInt("count1", count);
                edt1.putInt("randcolor1", randcolor);
                edt1.commit();
            }
        });
    }
/*  @Override
    public void onSaveInstanceState(Bundle bundle1){
        bundle1.putInt("count",count);
        bundle1.putInt("randcolor",randcolor);
        super.onSaveInstanceState(bundle1);
    }   */
}