package kolintdemo.util

import kolintdemo.MyApp

/**
 * Created by wangyuan on 2017/7/14.
 */
object StaticValue {
    val ACTIVITY :Int = 1;
    val FRAGMENT :Int = 2;
    val VIEW :Int = 3;

    val TRUE = 1
    val FALSE = 0


    var screenWidth : Int = 0;
    var screenHeight : Int = 0;
    var mApp : MyApp? = null;

    var EXTRA_NAME: String = "extra_name";
}