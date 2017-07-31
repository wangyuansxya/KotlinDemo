package kolintdemo.ext

import android.content.Context
import android.support.v4.app.Fragment
import android.widget.Toast
import kolintdemo.MyApp

/**
 * Created by wangyuan on 2017/7/31.
 */
inline fun Fragment.toast(context : Context = activity, msg: String?, duration : Int = Toast.LENGTH_SHORT) {
    Toast.makeText(context, msg, duration).show();
}

inline fun <reified T: Fragment> Fragment.showToast(context : Context = MyApp.getInstance(), msg: String?, duration : Int = Toast.LENGTH_SHORT) {
    Toast.makeText(context, msg, duration).show();
}