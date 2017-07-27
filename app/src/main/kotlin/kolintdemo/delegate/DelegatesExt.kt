package kolintdemo.delegate

import kolintdemo.bean.KotlinBean
import kotlin.properties.ReadWriteProperty

/**
 * Created by wangyuan on 2017/7/26.
 */
object DelegatesExt {
    fun <bean : KotlinBean> NotNullSingleValue() : ReadWriteProperty<Any?, KotlinBean> = NotNullSingleValueVar();
}