package com.wangyuan.kotlindemo


import android.os.Bundle
import android.support.v7.app.AppCompatActivity
// Using R.layout.activity_main from the main source set.引入xml文件
import kotlinx.android.synthetic.main.activity_kotlin.*
//import kotlinx.android.synthetic.main.<layout>.*

class KotlinActivity : AppCompatActivity() {
//    var mTv: TextView ?= null;
    var str: String = "123";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin);
//        mTvFirst.setText(str);
        init(0);
        initData();
        b(str);
    }

    /**
     * 无参数和返回值的方法
     */
    fun initData() {
    }

    /**
     * 带参数和返回值的方法
     */
    fun KotlinActivity.init(i: Int) : Int{
        mTvFirst.setOnClickListener {  };
        return 1;
    }

    /**
     * 带参数的方法
     */
    fun KotlinActivity.b(s: String?) {
        // Instead of findView(R.id.textView) as TextView.settext
        this.mTvFirst.setText(s);
    }
}
