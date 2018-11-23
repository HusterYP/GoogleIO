package com.hust.ping.googleio.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hust.ping.googleio.R;

/**
 * @created by PingYuan at 11/23/18
 * @email: husteryp@gmail.com
 * @description:
 */
public class NewWordActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.ping.hust.REPLY";

    private EditText mEditText;
    private Button mButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {
        setContentView(R.layout.activity_new_word);
        mEditText = findViewById(R.id.new_edit);
        mButton = findViewById(R.id.new_bt);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                if (TextUtils.isEmpty(mEditText.getText().toString())) {
                    setResult(RESULT_CANCELED, intent);
                } else {
                    intent.putExtra(EXTRA_REPLY, mEditText.getText().toString());
                    setResult(RESULT_OK, intent);
                }
                finish();
            }
        });
    }
}
