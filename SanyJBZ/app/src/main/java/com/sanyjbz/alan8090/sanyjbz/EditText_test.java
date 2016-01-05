package com.sanyjbz.alan8090.sanyjbz;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.Activity;
import android.widget.TextView;
/**
 * Created by Alan8090 on 2015-12-25.
 */
public class EditText_test extends Activity {
    private Button btn_add;
    private EditText edit_one;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edittext_test);
        btn_add = (Button) findViewById(R.id.btn_add);
        edit_one = (EditText) findViewById(R.id.edit_one);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpannableString spanStr = new SpannableString("imge");
                Drawable drawable = getResources().getDrawable(R.drawable.s_1);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                ImageSpan span = new ImageSpan(drawable, ImageSpan.ALIGN_BASELINE);
                spanStr.setSpan(span, 0, 4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                int cursor = edit_one.getSelectionStart();
                edit_one.getText().insert(cursor, spanStr);
            }
        });
    }



}
