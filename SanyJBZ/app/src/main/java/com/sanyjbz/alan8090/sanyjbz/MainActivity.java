package com.sanyjbz.alan8090.sanyjbz;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
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
    //进度条
    private Button btn_one;
    private Button btn_two;
    private Button btn_three;
    private ProgressDialog pd1 = null;
    private ProgressDialog pd2 = null;
    private final static int MAXVALUE = 100;
    private int progressStart = 0;
    private int add = 0;
    //定义一个用于更新进度的Handler,因为只能由主线程更新界面,所以要用Handler传递信息
    final Handler hand = new Handler()
    {
        @Override
        public void handleMessage(Message msg) {
            //这里的话如果接受到信息码是123
            if(msg.what == 123)
            {
                //设置进度条的当前值
                pd2.setProgress(progressStart);
            }
            //如果当前大于或等于进度条的最大值,调用dismiss()方法关闭对话框
            if(progressStart >= MAXVALUE)
            {
                pd2.dismiss();
            }
        }
    };

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
        //TextView tv=(TextView)findViewById(R.id.te);
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


        bindViews();

    }


    private void bindViews() {
        btn_one = (Button) findViewById(R.id.btn_one);
        btn_two = (Button) findViewById(R.id.btn_two);
        btn_three = (Button) findViewById(R.id.btn_three);
        btn_one.setOnClickListener(this);
        btn_two.setOnClickListener(this);
        btn_three.setOnClickListener(this);
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
//进度条
          case R.id.btn_one:
              //这里的话参数依次为,上下文,标题,内容,是否显示进度,是否可以用取消按钮关闭
              ProgressDialog.show(MainActivity.this, "资源加载中", "资源加载中,请稍后...",false,true);
              break;
          case R.id.btn_two:
              pd1 = new ProgressDialog(mContext);
              //依次设置标题,内容,是否用取消按钮关闭,是否显示进度
              pd1.setTitle("软件更新中");
              pd1.setMessage("软件正在更新中,请稍后...");
              pd1.setCancelable(true);
              //这里是设置进度条的风格,HORIZONTAL是水平进度条,SPINNER是圆形进度条
              pd1.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
              pd1.setIndeterminate(true);
              //调用show()方法将ProgressDialog显示出来
              pd1.show();
              break;
          case R.id.btn_three:
              //初始化属性
              progressStart = 0;
              add = 0;
              //依次设置一些属性
              pd2 = new ProgressDialog(MainActivity.this);
              pd2.setMax(MAXVALUE);
              pd2.setTitle("文件读取中");
              pd2.setMessage("文件加载中,请稍后...");
              //这里设置为不可以通过按取消按钮关闭进度条
              pd2.setCancelable(false);
              pd2.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
              //这里设置的是是否显示进度,设为false才是显示的哦！
              pd2.setIndeterminate(false);
              pd2.show();
              //这里的话新建一个线程,重写run()方法,
              new Thread()
              {
                  public void run()
                  {
                      while(progressStart < MAXVALUE)
                      {
                          //这里的算法是决定进度条变化的,可以按需要写
                          progressStart = 2 * usetime() ;
                          //把信息码发送给handle让更新界面
                          hand.sendEmptyMessage(123);
                      }
                  }
              }.start();
              break;

                  }
   }
    //这里设置一个耗时的方法:
    private int usetime() {
        add++;
        try{
            Thread.sleep(100);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        return add;
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
