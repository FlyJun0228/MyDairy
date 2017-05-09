package com.example.administrator.mydairy;

/**
 * Created by Administrator on 2017/5/9.
 */

public class Bean {

    private String Title;
    private String Content;

    public Bean(String title,String content){
        Title = title;
        Content = content;
    }
    public String getTitle(){
        return Title;
    }
    public String getContent(){
        return Content;
    }
}
