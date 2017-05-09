package com.example.administrator.mydairy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener{

    private Button mBtnAdd;

    private EditText mEdTitle;
    private EditText mEdContent;

    private String Title;
    private String Content;

    private DairyDao dairydao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        intiView();
        initListener();
    }
    public void intiView(){
        dairydao = new DairyDao(Main2Activity.this);
        mBtnAdd = (Button)findViewById(R.id.bt_sure);
        mEdContent = (EditText)findViewById(R.id.ed_content);
        mEdTitle = (EditText)findViewById(R.id.ed_title);
    }
    public void initListener(){
        mBtnAdd.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        Title = mEdTitle.getText().toString();
        Content = mEdContent.getText().toString();
        switch (view.getId()){
            case R.id.bt_sure:
                dairydao.Add(Title, Content);
                if (dairydao.Check == -1){
                    Toast.makeText(Main2Activity.this,"保存失败",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(Main2Activity.this,"保存成功",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Main2Activity.this,MainActivity.class);
                   /* intent.putExtra("title",Title);
                    intent.putExtra("content",Content);*/
                    startActivity(intent);
                    Main2Activity.this.finish();
                }
                break;
        }
    }
}
