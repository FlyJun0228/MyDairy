package com.example.administrator.mydairy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mBtnAdd;
    private ListView mLvShow;
    private DairyDao dairyDao;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
        Show();
    }
    public void initView(){
        dairyDao = new DairyDao(MainActivity.this);
        mBtnAdd = (Button)findViewById(R.id.bt_add);
        mLvShow = (ListView)findViewById(R.id.lv_show);
    }
    public void initListener(){
        mBtnAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_add:
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
                MainActivity.this.finish();
                break;
        }
    }
    public void Show(){
        dairyDao.Query();
        myAdapter = new MyAdapter(MainActivity.this,dairyDao.data);
        mLvShow.setAdapter(myAdapter);
    }
}
