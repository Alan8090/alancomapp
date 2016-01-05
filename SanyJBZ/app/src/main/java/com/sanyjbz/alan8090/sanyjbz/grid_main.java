package com.sanyjbz.alan8090.sanyjbz;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.Toast;

import com.sanyjbz.alan8090.sanyjbz.Entity.Icon_entity;

import java.util.ArrayList;

/**
 * Created by Alan8090 on 2016-01-05.
 */
public class grid_main extends AppCompatActivity {
    private Context mContext;
    private GridView grid_photo;
    private BaseAdapter mAdapter=null;
    private ArrayList<Icon_entity> mData=null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_main);
        mContext=grid_main.this;
        grid_photo=(GridView)findViewById(R.id.grid_photo);

        mData=new ArrayList<Icon_entity>();
        mData.add(new Icon_entity(R.mipmap.add,"图标一"));

        mAdapter=new MyAdapter<Icon_entity>(mData,R.layout.item_grid_icon) {
            @Override
        public void bindView(ViewHolder holder,Icon_entity obj){
                holder.setImageResource(R.id.img_icon,obj.getID());
                holder.setText(R.id.txt_icon,obj.getName());
            }
        };

        grid_photo.setAdapter(mAdapter);
        grid_photo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(mContext, "你点击了~" + position + "~项", Toast.LENGTH_SHORT).show();
            }
        });
/*
        grid_photo.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void OnItemClick(AdapterView<?> parent,View view,int position,long id){
                Toast.makeText(mContext,"你点击了"+position+"",Toast.LENGTH_LONG).show();
            }
        });
        */
    }
}
