package com.example.lab_3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private String[] names = new String[]{"Lion","Tiger","Monkey","Dog","Cat","elephant"};
    private int[] image=new int[]{R.drawable.lion,R.drawable.tiger,R.drawable.monkey,R.drawable.dog,R.drawable.cat,R.drawable.elephant};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //此处引用布局文件
        setContentView(R.layout.activity_main);
        final int color1 = 0xFFC5B5FF;
        final int color2 = 0xFFFFFFFF;
        //创建一个list集合，list集合的元素是Map
        List<Map<String, Object>> ListItems = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < names.length; i++) {
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put("header", names[i]);
            listItem.put("images", image[i]);
            //加入list集合
            ListItems.add(listItem);
        }
        //创建一个SimpleAdapter，此处严格按照定义数组names与image顺序,否则会出现程序build成功却运行失败且难以解决错误
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, ListItems, R.layout. activity_e1, new String[]{"header", "images"}, new int[]{R.id.header, R.id.images});
        final ListView list = (ListView) findViewById(R.id.mylist);
        //为ListView设置Adapter
        list.setAdapter(simpleAdapter);
        //对应点击事件
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int flag = 0;
                System.out.println(names[position] + position + "被单击");
                //点击则改变状态，改变颜色
                switch (flag) {
                    case 0:
                        //view.setBackgroundColor(color1);
                        //此处对应上面布局文件的点击函数
                        view.setSelected(true);
                        CharSequence text = names[position];
                        //定义一个Toast表示哪一个图片所在item被点击
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(MainActivity.this, text, duration);
                        toast.show();
                        flag = 1;
                        break;
                    case 1:
                        //view.setBackgroundColor(color2);
                        view.setSelected(false);
                        CharSequence text1 = names[position];
                        int duration1 = Toast.LENGTH_SHORT;
                        Toast toast1 = Toast.makeText(MainActivity.this, text1, duration1);
                        toast1.show();
                        flag = 0;
                        break;
                }
            }
        });
        //选中函数
        list.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                System.out.println(names[position] + "选中");
            }

            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }    }
