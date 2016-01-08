package com.sanyjbz.alan8090.sanyjbz;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by Alan8090 on 2016-01-08.
 */
public class Handler_test extends Activity {
    //定义切换的图片的数组id
    int imgids[]=new int[]{
            R.drawable.s_1,R.drawable.s_2,R.drawable.s_3,
            R.drawable.s_4,R.drawable.s_5,R.drawable.s_6,
            R.drawable.s_7,R.drawable.s_8
    };
    int imgstart=0;

    final Handler myHandler=new Handler() {
        @Override
        //重写handleMessage方法,根据msg中what的值判断是否执行后续操作
        public void handleMessage(Message msg){
            if(msg.what==0x123)
            {
                imgchange.setImageResource(imgids[imgstart++%8]);
            }
        }

    };
    ImageView imgchange=null;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.handler_test);
        imgchange=(ImageView)findViewById(R.id.imgchange);
        //使用定时器,每隔200毫秒让handler发送一个空信息
        new Timer().schedule(new TimerTask()
        {
            @Override
            public void run(){
                myHandler.sendEmptyMessage(0x123);
            }
        },0,200);

        //启动新线程
        calThread.start();
    }

    //为按钮的点击事件提供事件处理函数
    public void cal(View source)
    {
        //创建消息
        Message msg=new Message();
        msg.what=0x123;
        Bundle bundle=new Bundle();
        bundle.putInt(UPPER_NUM,Integer.parseInt(etNum.getText().toString()));
        msg.setData(bundle);
        // 向新线程中的Handler发送消息
        calThread.mHandler.sendMessage(msg);
    }


    static final String UPPER_NUM="upper";
    EditText etNum;
    CalThread calThread;
    // 定义一个线程类
    class CalThread extends Thread
    {
        public Handler mHandler;

        public void run() {
            Looper.prepare();
            mHandler=new Handler()
            {
                // 定义处理消息的方法
                @Override
                public void handleMessage(Message msg)
                {
                    if(msg.what==0x123)
                    {
                        int upper=msg.getData().getInt(UPPER_NUM);
                        List<Integer> nums=new ArrayList<Integer>();
                        // 计算从2开始、到upper的所有质数
                        outer:
                        for(int i=2;i<=upper;i++)
                        {
                            // 用i处于从2开始、到i的平方根的所有数
                            for(int j=2;j<=Math.sqrt(i);j++)
                            {
                                // 如果可以整除，表明这个数不是质数
                                if(i!=2&&i%j==0) {
                                    continue outer;
                                }
                            }
                            nums.add(i);
                        }
                        // 使用Toast显示统计出来的所有质数
                        Toast.makeText(Handler_test.this,nums.toString(),Toast.LENGTH_LONG).show();
                    }
                }
            };
            Looper.loop();
        }

    }

}
