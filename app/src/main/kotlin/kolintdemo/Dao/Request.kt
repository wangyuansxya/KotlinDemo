package kolintdemo.Dao

import android.util.Log
import java.net.URL

/**
 * Created by wangyuan on 2017/7/20.
 */
class Request(val url : String) {
    public fun run() {
        val result = URL(url).readText();
        Log.d("result", "result : $result");
    }
}