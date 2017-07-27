package com.wangyuan.kotlindemo


// Using R.layout.activity_main from the main source set.引入xml文件
import android.os.Bundle
import kolintdemo.activity.BaseKotlinFragmentActivity
import kolintdemo.activity.MyActivity
import kotlinx.android.synthetic.main.kotlin_fragment_activity.*

//import kotlinx.android.synthetic.main.<layout>.*

class KotlinActivity : BaseKotlinFragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_kotlin);
        setContentView(R.layout.kotlin_fragment_activity);
        var extr : String? = intent.extras.getString(MyActivity.EXTRA_NAME);
        /*var args : Bundle = Bundle();
        args.putString(StaticValue.EXTRA_NAME, extr);
        kotlin_my_fragment.arguments = args;*/
        mTvTitle.setText(extr);

        for (i in 0..10 step 2) {
            println("KotlinActivity自增$i");
        }

        for (i in 10 downTo 0 step 2) {
            println("KotlinActivity自减$i");
        }

        //开区间
        for (i in 0 until 10 step 2) {
            println("KotlinActivity开区间自增$i");
        }

    }
}
