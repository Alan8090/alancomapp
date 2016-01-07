package com.sanyjbz.alan8090.sanyjbz;


import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.app.Activity;
import android.widget.TextView;
import android.widget.Toast;

import com.sanyjbz.alan8090.sanyjbz.Alan_Control.midToast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
/*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    */
private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = MainActivity.this;

        FrameLayout frame = (FrameLayout) findViewById(R.id.mylayout);
        final MeziView mezi = new MeziView(MainActivity.this);
        //为我们的萌妹子添加触摸事件监听器
        /*
        mezi.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                //设置妹子显示的位置
                mezi.bitmapX = event.getX() - 150;
                mezi.bitmapY = event.getY() - 150;
                //调用重绘方法
                mezi.invalidate();
                return true;
            }
        });
        frame.addView(mezi);
*/
        TextView tv=(TextView)findViewById(R.id.txt1);
        Button btn=(Button)findViewById(R.id.btn_toast);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                midToast.midToast("abc", Toast.LENGTH_LONG,MainActivity.this);
                //midToast.showToast(MainActivity.this,"abc");
            }
        });

       Button btn_alertdialog=(Button)findViewById(R.id.btn_alterdialog);
        btn_alertdialog.setOnClickListener(this);
    }
    private AlertDialog alert = null;
    private AlertDialog.Builder builder = null;

    @Override
   public void onClick(View v)
   {
      switch (v.getId()){
          //普通对话框
          case R.id.btn_alterdialog:

          alert=null;
              builder = new AlertDialog.Builder(mContext);
              alert=builder.setIcon(R.drawable.s_1)
                  .setTitle("系统提示")
                  .setMessage("这是一个最普通的AlertDialog,\\n带有三个按钮，分别是取消，中立和确定")
                  .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                              @Override
                              public void onClick(DialogInterface dialog, int which) {
                                  Toast.makeText(mContext, "你点击了取消按钮~", Toast.LENGTH_SHORT).show();

                              }
                          }
                  )
                          .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                              @Override
                              public void onClick(DialogInterface dialog, int which) {
                                  Toast.makeText(mContext, "你点击了确定按钮~", Toast.LENGTH_SHORT).show();
                              }
                          })
                              .setNeutralButton("中立", new DialogInterface.OnClickListener() {
                                  @Override
                                  public void onClick(DialogInterface dialog, int which) {
                                      Toast.makeText(mContext, "你点击了中立按钮~", Toast.LENGTH_SHORT).show();
                                  }
                              }).create();             //创建AlertDialog对象
                      alert.show();                    //显示对话框
                      break;


                  }
   }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
