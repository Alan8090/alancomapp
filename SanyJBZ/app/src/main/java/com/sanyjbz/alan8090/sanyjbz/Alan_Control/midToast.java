package com.sanyjbz.alan8090.sanyjbz.Alan_Control;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sanyjbz.alan8090.sanyjbz.R;

public class midToast {


/*
    private Button btn_toast;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = MainActivity.this;
        btn_toast = (Button) findViewById(R.id.btn_toast);
        btn_toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                midToast("提莫队长，正在送命~",Toast.LENGTH_SHORT);
            }
        });
    }
*/
    private static View view=null;
    public static void midToast(String str, int showTime,Activity activity)
    {
        if(view==null) {
            LayoutInflater inflater = activity.getLayoutInflater();
            view = inflater.inflate(R.layout.view_toast_custom,
                    (ViewGroup) activity.findViewById(R.id.lly_toast));
            ImageView img_logo = (ImageView) view.findViewById(R.id.img_logo);
            TextView tv_msg = (TextView) view.findViewById(R.id.tv_msg);
            tv_msg.setText(str);
        }
      if(toast==null) {

          toast = new Toast(activity);

          toast.setGravity(Gravity.CENTER, 0, 0);
          toast.setDuration(Toast.LENGTH_LONG);
          toast.setView(view);
          toast.show();
          oneTime=System.currentTimeMillis();
      }else{
          twoTime=System.currentTimeMillis();
          if(str.equals(oldMsg)){
              if(twoTime-oneTime>Toast.LENGTH_SHORT){
                  toast.show();
              }
          }else{
              oldMsg = str;
              toast.setView(view);
              toast.show();
          }
      }
        oneTime=twoTime;

    }

    private static String oldMsg;
    protected static Toast toast   = null;
    private static long oneTime=0;
    private static long twoTime=0;

    public static void showToast(Context context, String s){
      if(toast==null){
             toast =Toast.makeText(context, s, Toast.LENGTH_SHORT);
             toast.show();
             oneTime=System.currentTimeMillis();
          }else{
                twoTime=System.currentTimeMillis();
                  if(s.equals(oldMsg)){
                                 if(twoTime-oneTime>Toast.LENGTH_SHORT){
                                       toast.show();
                                   }
                         }else{
                         oldMsg = s;
                            toast.setText(s);
                           toast.show();
                      }
               }
                  oneTime=twoTime;
            }


         public static void showToast(Context context, int resId){
              showToast(context, context.getString(resId));
         }



}











/*
不用计算Toast的时间之类的，就是定义一个全局的成员变量Toast,
这个Toast不为null的时候才去make,否则直接setText.为了按返回键后立即使Toast不再显示，重写父类Activity的onBackPressed()方法里面去cancel你的Toast即可.

 
private Toast mToast;
    public void showToast(String text) {
        if(mToast == null) {
            mToast = Toast.makeText(TestActivity.this, text, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(text);
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
        mToast.show();
    }

    public void cancelToast() {
            if (mToast != null) {
                mToast.cancel();
            }
        }

    public void onBackPressed() {
            cancelToast();
            super.onBackPressed();
        }
 */











