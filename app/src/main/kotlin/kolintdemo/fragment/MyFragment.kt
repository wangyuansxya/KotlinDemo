package kolintdemo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.wangyuan.kotlindemo.R
import kotlinx.android.synthetic.main.kotlin_frag.*

/**
 * Created by wangyuan on 2017/7/12.
 */
class MyFragment : AbsBaseFragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var v = inflater?.inflate(R.layout.kotlin_frag, container, false)
        initView();
        return v
    }

    fun initView() {
        btn_kotlin_frag.setOnClickListener {
            toast("测试kotlin Toast", Toast.LENGTH_LONG);
        }
    }

}