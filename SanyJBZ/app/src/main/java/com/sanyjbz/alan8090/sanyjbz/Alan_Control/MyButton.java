package com.sanyjbz.alan8090.sanyjbz.Alan_Control;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.Toast;

import com.sanyjbz.alan8090.sanyjbz.MainActivity;

import java.util.jar.Attributes;

/**
 * Created by Alan8090 on 2016-01-08.
 */
public class MyButton extends Button {
    private static String TAG="Alan";
    private Context mContext;
    public MyButton(Context context,AttributeSet attrs)
    {
        super(context,attrs);
        mContext=context;
    }

    //重写键盘按下触发的事件
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        super.onKeyDown(keyCode,event);
        Log.i(TAG, "onKeyDown方法被调用");
        Toast.makeText(mContext, "onKeyDown方法被调用", Toast.LENGTH_SHORT).show();

        return true;
    }

    //重写弹起键盘触发的事件
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        super.onKeyUp(keyCode,event);
        Log.i(TAG,"onKeyUp方法被调用");
        Toast.makeText(mContext, "onKeyUp方法被调用", Toast.LENGTH_SHORT).show();
        return true;
    }

    //组件被触摸了
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        Log.i(TAG,"onTouchEvent方法被调用");
        Toast.makeText(mContext, "onTouchEvent方法被调用", Toast.LENGTH_SHORT).show();
        return true;
    }

}
