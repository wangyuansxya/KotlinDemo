package kolintdemo

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.wangyuan.kotlindemo.R
import kolintdemo.activity.BaseKotlinFragmentActivity
import kolintdemo.adapter.MainAdapter
import kolintdemo.bean.KotlinBean
import kolintdemo.util.StaticValue
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by wangyuan on 2017/7/12.
 */
class MainActivity : BaseKotlinFragmentActivity() {
    private val arr : Array<String> = arrayOf("activity", "fragment", "adapter")
    private var list : List<KotlinBean>? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.kotlin_fragment_activity);
        setContentView(R.layout.activity_main);
        initView();
    }

    fun initView() {
        var activity : KotlinBean = KotlinBean(StaticValue.ACTIVITY, "activity", "测试kotlin Activity");
        var fragment : KotlinBean = KotlinBean(StaticValue.FRAGMENT, "fragment", "测试kotlin fragment");
        var adapter : KotlinBean = KotlinBean(StaticValue.VIEW, "View", "测试kotlin View");

        list = listOf<KotlinBean>(activity, fragment, adapter);

        mRecycleView.layoutManager = LinearLayoutManager(this);
        mRecycleView.adapter = MainAdapter(this, list);
        Log.d("MainActivity", "MainActivity=" + arr.asList())
    }

}