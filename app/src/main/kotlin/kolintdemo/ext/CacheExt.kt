package kolintdemo.ext

import android.content.Context
import kolintdemo.MyApp
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Created by wangyuan on 2017/8/7.
 */

object CacheExt{
    fun <T>preference(context: Context, spName: String, name: String, value: T) = MySharePreference(context, spName,name, value);
}
class MySharePreference<T>(val context: Context = MyApp.getInstance(), val spName: String, val key : String, val value : T) : ReadWriteProperty<Any?, T> {

    val prefs by lazy {
        context.getSharedPreferences(spName, Context.MODE_PRIVATE);
    }

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return findSharePreFerence(key, value);
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        putSharePreFerence(key, value);
    }

    private fun findSharePreFerence(key : String, value: T) = with(prefs) {

        val res : Any = when(value) {
            is Long -> getLong(key, value);
            is String -> getString(key, value);
            is Int -> getInt(key, value);
            is Boolean -> getBoolean(key, value);
            is Float -> getFloat(key, value);
            else -> throw IllegalArgumentException("This type can be saved into Preferences");
        }
        res as T;
    }

    private fun putSharePreFerence(key : String, value: T) = with(prefs.edit()) {
        when(value) {
            is Long -> putLong(key, value);
            is String -> putString(key, value);
            is Int -> putInt(key, value);
            is Boolean -> putBoolean(key, value);
            is Float -> putFloat(key, value);
            else -> throw IllegalArgumentException("This type can be saved into Preferences");
        }.commit();
    }
}

/*
fun getBoolean(spName : String?, key : String, value : Boolean = false) : Boolean? {
    return MyApp.getInstance()?.getSharedPreferences(spName, Context.MODE_PRIVATE)?.getBoolean(key, value)
}

fun setBoolean(spName : String?, key : String, value : Boolean = false) {
    MyApp.getInstance()?.getSharedPreferences(spName, Context.MODE_PRIVATE)?.edit()?.putBoolean(key, value)
}

fun getInt(spName : String?, key : String, value : Int = 0) : Int? {
    return MyApp.getInstance()?.getSharedPreferences(spName, Context.MODE_PRIVATE)?.getInt(key, value)
}

fun setInt(spName : String?, key : String, value : Int = 0) {
    MyApp.getInstance()?.getSharedPreferences(spName, Context.MODE_PRIVATE)?.edit()?.putInt(key, value)
}

fun getString(spName : String?, key : String, value : String = "") : String? {
    return MyApp.getInstance()?.getSharedPreferences(spName, Context.MODE_PRIVATE)?.getString(key, value)
}

fun setString(spName : String?, key : String, value : String = "") {
    MyApp.getInstance()?.getSharedPreferences(spName, Context.MODE_PRIVATE)?.edit()?.putString(key, value)
}

fun getLong(spName : String?, key : String, value : Long = 0L) {
    MyApp.getInstance()?.getSharedPreferences(spName, Context.MODE_PRIVATE)?.getLong(key, value)
}

fun setLong(spName : String?, key : String, value : Long = 0L) {
    MyApp.getInstance()?.getSharedPreferences(spName, Context.MODE_PRIVATE)?.edit()?.putLong(key, value)
}*/
