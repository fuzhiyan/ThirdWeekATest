package com.bwei.test.thirdweekatest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private TextView textView;
    private List<String> list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView= (ListView) findViewById(R.id.lv);
        initData();
        //为listview适配数据
        listView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return  list.size();
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
                    convertView=View.inflate(MainActivity.this,R.layout.item,null);
                    textView= (TextView) convertView.findViewById(R.id.item_text);
                }
                textView.setText(list.get(position));
                return convertView;
            }
        });
        //listview子条目监听事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //把当前点击的条目传到下个页面
                Intent in=new Intent();
                in.putExtra("extra",list.get(position));
                in.setClass(MainActivity.this,TwoActivity.class);
                startActivity(in);
            }
        });
    }

    //添加数据
    private void initData() {
        list.add("北京");
        list.add("上海");
        list.add("广东");
        list.add("南京");
        list.add("吕梁");
        list.add("武汉");
        list.add("太原");
        list.add("杭州");
        list.add("南宁");
        list.add("深圳");


    }
}
