package kolintdemo.fragment

import android.support.v4.app.Fragment
import android.widget.Toast

/**
 * Created by wangyuan on 2017/7/12.
 */
open class AbsBaseFragment : Fragment() {

    fun Fragment.toast(text: CharSequence?, duration : Int = Toast.LENGTH_SHORT) {
        Toast.makeText(activity, text, duration).show()
    }

}