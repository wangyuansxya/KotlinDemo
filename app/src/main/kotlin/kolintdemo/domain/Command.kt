package kolintdemo.domain

/**
 * Created by wangyuan on 2017/7/24.
 */
interface Command<T> {
    fun execute() : T;
}