package com.example.administrator.dragflexboxlayout;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.administrator.dragflexboxlayout.flow.FlowLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {

    FlowLayout flowLayout;
    List<TagModel> dataList;

    String[] ss = new String[]{
            "我要飞" , "第一" , "今天真的太爽了e" , "北京的城市" , "也" , "没想到你吧" , "记录一下这样这样" , "动感小炒肉"
    };

    MyFlowAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniData();
        flowLayout = (FlowLayout) findViewById(R.id.flow);
        adapter = new MyFlowAdapter(this);
        flowLayout.setAdapter(adapter);
        adapter.replaceAll(dataList);
    }

    public void click(View v){
        adapter.notifyDataSetChanged();
    }

    void iniData(){
        dataList = new ArrayList<>();
        int count = 20;
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            int bgColor = 0xff000000 | random.nextInt(0x00ffffff);
            int strokeColor = 0xff000000 | random.nextInt(0x00ffffff);
            int textColor = 0xff000000 | random.nextInt(0x00ffffff);
            int connerDp = random.nextInt(20);
            int strokeWidth = 0;
            String text = ss[random.nextInt(ss.length)];
            TagModel model = new TagModel(bgColor,textColor,strokeColor,text,connerDp,strokeWidth);
            Log.e("aa" , " Tag : " + model.toString());
            dataList.add(model);
        }
    }

    public static String createRandom(boolean numberFlag, int length){
        String retStr = "";
        String strTable = numberFlag ? "1234567890" : "1234567890abcdefghijkmnpqrstuvwxyz";
        int len = strTable.length();
        boolean bDone = true;
        do {
            retStr = "";
            int count = 0;
            for (int i = 0; i < length; i++) {
                double dblR = Math.random() * len;
                int intR = (int) Math.floor(dblR);
                char c = strTable.charAt(intR);
                if (('0' <= c) && (c <= '9')) {
                    count++;
                }
                retStr += strTable.charAt(intR);
            }
            if (count >= 2) {
                bDone = false;
            }
        } while (bDone);

        return retStr;
    }
}
