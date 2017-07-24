package kolintdemo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wangyuan.kotlindemo.R
import kolintdemo.view.TimePickerView
import org.jetbrains.anko.support.v4.toast

/**
 * Created by wangyuan on 2017/7/12.
 */
class MyFragment : AbsBaseFragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var v = inflater?.inflate(R.layout.kotlin_frag, container, false)
        initView(v);
        return v
    }

    var timeView : TimePickerView? = null;

    fun initView(v : View?) {
        /*btn_kotlin_frag.setOnClickListener {
            toast("测试kotlin Toast", Toast.LENGTH_LONG);
        }*/
//        toast("测试kotlin Toast", Toast.LENGTH_LONG);


        this.timeView = v!!.findViewById(R.id.timeView) as TimePickerView;
        if(timeView != null) {
            timeView!!.setOnClickListener(timeView)
            timeView!!.buildBlocks(StaticValue.TRUE);
            timeView!!.setCallBack(lis);
        }
    }

    val lis = object : TimePickerView.OnItemSelected {
        override fun onItemTimeSelect(timeId: Int, time: String) {
//            toast(time, Toast.LENGTH_SHORT);
            toast(time);
        }
    }
}