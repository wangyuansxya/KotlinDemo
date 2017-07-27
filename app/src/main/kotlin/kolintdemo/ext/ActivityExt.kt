package kolintdemo.ext

import android.app.Activity
import android.content.Context
import android.content.Intent

/**
 * Created by wangyuan on 2017/7/27.
 */
public inline fun <reified T: Activity> Context.startActivity(vararg params: Pair<String, String>) {
    val intent = Intent(this, T :: class.java)
    params.forEach { intent.putExtra(it.first, it.second) }
    startActivity(intent)
}