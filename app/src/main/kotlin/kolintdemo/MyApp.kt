package kolintdemo

import android.app.Application

/**
 * Created by wangyuan on 2017/7/12.
 */
open class MyApp : Application() {

    var mApp : MyApp? = null;

    override fun onCreate() {
        super.onCreate()
        mApp = this;
    }

    companion object {

        fun getInstance(): MyApp {
            return MyApp().mApp!!;
        }
    }
}