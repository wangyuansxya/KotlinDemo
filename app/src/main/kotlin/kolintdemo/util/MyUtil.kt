package kolintdemo.util

import kolintdemo.MyApp

/**
 * Created by wangyuan on 2017/7/12.
 */
object MyUtil {

    fun dip2px(dipValue: Float): Int {
        val scale = MyApp.getInstance().getResources()
                .getDisplayMetrics().density
        return (dipValue * scale + 0.5f).toInt()
    }

    private val TIME_ARRAY = arrayOf(arrayOf("06:00", "06:30", "07:00", "07:30", "08:00"), arrayOf("08:30", "09:00", "09:30", "10:00", "10:30"), arrayOf("11:00", "11:30", "12:00", "12:30", "13:00"), arrayOf("13:30", "14:00", "14:30", "15:00", "15:30"), arrayOf("16:00", "16:30", "17:00", "17:30", "18:00"), arrayOf("18:30", "19:00", "19:30", "20:00", "20:30"), arrayOf("21:00", "21:30", "22:00", "22:30", "23:00"), arrayOf("23:30"))

}