package kolintdemo.Dao

import android.util.Log
import kolintdemo.bean.KotlinBean
import org.json.JSONObject
import java.net.URL

/**
 * Created by wangyuan on 2017/7/20.
 */
class Request(val zipcode : String) {

    companion object {
        //http://samples.openweathermap.org/data/2.5/weather?zip=94040,us&appid=b1b15e88fa797225412429c1c50c122a1
        val APP_ID = "b1b15e88fa797225412429c1c50c122a1";
        val URL = "http://samples.openweathermap.org/data/2.5/weather?zip=94040,us";
        val COMPLETE_URL = "$URL&appid=$APP_ID&q="
    }

    fun run() : KotlinBean {
        val result = URL(COMPLETE_URL + zipcode).readText();
        Log.d("result", "result : $result");
        val bean = KotlinBean().parse(JSONObject(result));
        return bean;
    }
}