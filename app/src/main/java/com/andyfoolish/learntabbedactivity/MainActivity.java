package com.andyfoolish.learntabbedactivity;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {
    //作为putExtra()的第一个参数--键名
    public final static String EXTRA_MESSAGE="com.dlut.learntabbedactivity.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void sendMessage(View view){
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        //把EditText的文本内容关联到一个本地 message 变量
        String message = editText.getText().toString();
        //使用putExtra()方法把值传给intent
        intent.putExtra(EXTRA_MESSAGE, message);
        //运行这个方法，系统收到我们的请求后会实例化在Intent中指定的Activity
        startActivity(intent);
    }


}
