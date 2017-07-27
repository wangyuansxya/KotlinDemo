package kolintdemo

import android.app.Application

/**
 * Created by wangyuan on 2017/7/12.
 */
class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        val dm = getResources().getDisplayMetrics()
        screenWidth = dm.widthPixels
        screenHeight = dm.heightPixels
        mApp = this;
    }

    companion object {
        var screenWidth : Int = 0;
        var screenHeight : Int = 0;
        private var mApp : MyApp? = null

        fun getInstance() : MyApp = mApp!!;
    }

}