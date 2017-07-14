package kolintdemo

import android.app.Application
import kolintdemo.util.StaticValue

/**
 * Created by wangyuan on 2017/7/12.
 */
open class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        StaticValue.mApp = this;
        val dm = getResources().getDisplayMetrics()
        StaticValue.screenWidth = dm.widthPixels
        StaticValue.screenHeight = dm.heightPixels
    }
}