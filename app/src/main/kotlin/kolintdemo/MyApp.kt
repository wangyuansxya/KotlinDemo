package kolintdemo

import android.app.Application

/**
 * Created by wangyuan on 2017/7/12.
 */
object MyApp : Application() {

    var mApp : MyApp? = null;

    override fun onCreate() {
        super.onCreate()
        mApp = this;
    }

    fun MyApp.getInstance() : MyApp? {
        return mApp;
    }
}