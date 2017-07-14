package com.wangyuan.kotlindemo


// Using R.layout.activity_main from the main source set.引入xml文件
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kolintdemo.activity.MyActivity
import kotlinx.android.synthetic.main.activity_kotlin.*

//import kotlinx.android.synthetic.main.<layout>.*

class KotlinActivity : AppCompatActivity() {
//    var mTv: TextView ?= null;
    val str: String = "123";

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
    fun KotlinActivity.init(i: Int ) : Int{
        mTvFirst.setOnClickListener {
            intent.setClass(this@KotlinActivity, MyActivity:: class.java);
            intent.putExtra(/*MyActivity::EXTRA_NAME*/"extra_name", "测试kotlin页面跳转");
            startActivity(intent);
        };
        return 1;
    }

    /**
     * 带参数的方法
     */
    fun KotlinActivity.b(s: String?) {
        // Instead of findView(R.id.textView) as TextView.settext
        this.mTvFirst.setText(s);
    }

    fun onClick(v : View) {

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }
}
