package com.example.lab_3_4;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    //    private ActionMode mode;
    private ActionMode.Callback mCallBack=new ActionMode.Callback() {
        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {

            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            // TODO Auto-generated method stub
        }

        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            MenuInflater inflater = mode.getMenuInflater();
            inflater.inflate(R.menu.contextt, menu);
            return true;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            boolean ret = false;
            if (item.getItemId() == R.id.menu_delete) {
                mode.finish();
                ret = true;
            }
            return ret;
        }
    };

    public void onCreate(Bundle bb){
        super.onCreate(bb);
        setContentView(R.layout.activity_main);
        final SimpleAdapter adapter=new SimpleAdapter(this,getData(),R.layout.itrms,new String[]{"title","image"},new int []{R.id.textt,R.id.imm});
        ListView listView=(ListView)findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                view.setSelected(true);
                int ll=adapter.getCount();
                startActionMode(mCallBack);

            }
        });

    }
    public List<Map<String,Object>>getData(){
        List<Map<String,Object>>list=new ArrayList<Map<String,Object>>();
        Map<String ,Object> map;
        map=new HashMap<String,Object>();
        map.put("title","One");
        map.put("image",R.drawable.jq);
        list.add(map);

        map=new HashMap<String,Object>();
        map.put("title","Two");
        map.put("image",R.drawable.jq);
        list.add(map);

        map=new HashMap<String,Object>();
        map.put("title","Three");
        map.put("image",R.drawable.jq);
        list.add(map);

        map=new HashMap<String,Object>();
        map.put("title","Four");
        map.put("image",R.drawable.jq);
        list.add(map);

        map=new HashMap<String,Object>();
        map.put("title","Five");
        map.put("image",R.drawable.jq);
        list.add(map);
        return list;
    }

}