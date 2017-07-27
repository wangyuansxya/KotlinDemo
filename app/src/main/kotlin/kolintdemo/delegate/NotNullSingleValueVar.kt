package kolintdemo.delegate

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Created by wangyuan on 2017/7/26.
 */
public class NotNullSingleValueVar<T>() : ReadWriteProperty<Any?, T>{

    private var value : T? = null;

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return value ?: throw IllegalStateException("${value}".plus("not initialized"));
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        this.value = if(this.value == null)value
        else throw IllegalStateException("${value}".plus("already initialized"));
    }
}