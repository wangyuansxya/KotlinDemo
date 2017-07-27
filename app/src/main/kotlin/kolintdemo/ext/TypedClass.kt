package kolintdemo.ext

/**
 * Created by wangyuan on 2017/7/27.
 */
class TypedClass<T : Any?>(parameter: T) {
    val value: T = parameter
}