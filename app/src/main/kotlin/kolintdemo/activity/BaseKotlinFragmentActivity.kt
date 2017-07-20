package kolintdemo.activity

import android.support.v4.app.FragmentActivity
import com.wangyuan.kotlindemo.KotlinActivity
import kotlinx.android.synthetic.main.activity_kotlin.*

/**
 * Created by wangyuan on 2017/7/12.
 */
open class BaseKotlinFragmentActivity : FragmentActivity() {

    private val items = listOf<String>(
            "a","b",
            "c","d",
            "e","f",
            "g","h"
    )

    private val arr = arrayOf(
            "", ""
    )

    /**
     * 带参数和返回值的方法
     */
    fun KotlinActivity.init(i: Int ) : Int{
        mTvFirst.setOnClickListener {
            intent.setClass(this@BaseKotlinFragmentActivity, MyActivity:: class.java);
            intent.putExtra(/*MyActivity::EXTRA_NAME*/"extra_name", "测试kotlin页面跳转");
            startActivity(intent);
        };
        return 1;
    }

    /**
     * 无参数和返回值的方法
     */
    fun initData() {

    }

    /**
     * 带参数的方法
     */
    fun KotlinActivity.b(s: String?) {
        // Instead of findView(R.id.textView) as TextView.settext
        this.mTvFirst.setText(s);
    }
}