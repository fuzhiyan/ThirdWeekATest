package com.bwei.test.thirdweekatest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/24.
 * time:
 * author:付智焱
 */
public class TwoActivity  extends AppCompatActivity{
    private ListView listView;
    private TextView textView,textView2,textView3,textView4;
    private ImageView imageView;
    private List<HashMap<String,String>> list=new ArrayList<HashMap<String, String>>();
    private HashMap<String,String> hashMap=new HashMap<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.two);
        listView= (ListView) findViewById(R.id.two_lv);
        textView= (TextView) findViewById(R.id.two_text);
        Intent in=getIntent();
        String str=in.getStringExtra("extra");
        textView.setText(str);

        //循环添加7条数据
        for(int i=0;i<7;i++) {
            hashMap.put("image", ""+R.mipmap.ic_launcher);
            hashMap.put("info", "多云");
            hashMap.put("gr", "2-15C°");
            hashMap.put("day", "2-17");
            list.add(hashMap);
        }


        listView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public Object getItem(int position) {
                return list.get(position);
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if(convertView==null){
                    convertView=View.inflate(TwoActivity.this,R.layout.two_item,null);
                    textView2= (TextView) convertView.findViewById(R.id.text_info);
                    textView3= (TextView) convertView.findViewById(R.id.text_gr);
                    textView4= (TextView) convertView.findViewById(R.id.text_date);
                    imageView= (ImageView) convertView.findViewById(R.id.two_image);

                }

                //迭代器遍历map集合。获取key
                Iterator  it=hashMap.entrySet().iterator();
                while(it.hasNext()){

                    Map.Entry<String,String> entry= (Map.Entry<String, String>) it.next();
                    String key=entry.getKey();
                    String value=entry.getValue();
                    //判断key值。然后给相应的textview赋值
                    if(key.equals("image")){
                        imageView.setBackgroundResource(Integer.parseInt(value));
                    }
                    if(key.equals("info")){
                        textView2.setText(value);
                    }if(key.equals("gr")){
                        textView3.setText(value);
                    }if(key.equals("day")){
                        textView4.setText(value);
                    }

                }
                return convertView;
            }
        });



    }
}
