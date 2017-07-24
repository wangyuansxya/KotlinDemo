package kolintdemo.util

import kolintdemo.MyApp
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by wangyuan on 2017/7/12.
 */
object MyUtil {

    fun dip2px(dipValue: Float): Int {
        val scale = MyApp.mApp!!.getResources()
                .getDisplayMetrics().density
        return (dipValue * scale + 0.5f).toInt()
    }

    /**
     * sp转像素
     */
    fun sp2px(spValue: Float): Float {
        val scale = MyApp.mApp!!.getResources()
                .getDisplayMetrics().scaledDensity
        return (spValue * scale + 0.5f).toFloat();
    }

    fun getTimeToID(strTime: String): String {
        if (mTimeToIdMap == null) {
            synchronized(MyUtil::class.java) {
                if (mTimeToIdMap == null) {
                    initTimeToIdMapping()
                }
            }
        }
        return mTimeToIdMap!!.get(strTime) as String;
    }

    private var mTimeToIdMap: HashMap<String, String>? = null

    private fun initTimeToIdMapping() {
        mTimeToIdMap = HashMap<String, String>(48)
        mTimeToIdMap!!.put("00:00", "1")
        mTimeToIdMap!!.put("00:30", "2")
        mTimeToIdMap!!.put("01:00", "3")
        mTimeToIdMap!!.put("01:30", "4")
        mTimeToIdMap!!.put("02:00", "5")
        mTimeToIdMap!!.put("02:30", "6")
        mTimeToIdMap!!.put("03:00", "7")
        mTimeToIdMap!!.put("03:30", "8")
        mTimeToIdMap!!.put("04:00", "9")
        mTimeToIdMap!!.put("04:30", "10")
        mTimeToIdMap!!.put("05:00", "11")
        mTimeToIdMap!!.put("05:30", "12")
        mTimeToIdMap!!.put("06:00", "13")
        mTimeToIdMap!!.put("06:30", "14")
        mTimeToIdMap!!.put("07:00", "15")
        mTimeToIdMap!!.put("07:30", "16")
        mTimeToIdMap!!.put("08:00", "17")
        mTimeToIdMap!!.put("08:30", "18")
        mTimeToIdMap!!.put("09:00", "19")
        mTimeToIdMap!!.put("09:30", "20")
        mTimeToIdMap!!.put("10:00", "21")
        mTimeToIdMap!!.put("10:30", "22")
        mTimeToIdMap!!.put("11:00", "23")
        mTimeToIdMap!!.put("11:30", "24")
        mTimeToIdMap!!.put("12:00", "25")
        mTimeToIdMap!!.put("12:30", "26")
        mTimeToIdMap!!.put("13:00", "27")
        mTimeToIdMap!!.put("13:30", "28")
        mTimeToIdMap!!.put("14:00", "29")
        mTimeToIdMap!!.put("14:30", "30")
        mTimeToIdMap!!.put("15:00", "31")
        mTimeToIdMap!!.put("15:30", "32")
        mTimeToIdMap!!.put("16:00", "33")
        mTimeToIdMap!!.put("16:30", "34")
        mTimeToIdMap!!.put("17:00", "35")
        mTimeToIdMap!!.put("17:30", "36")
        mTimeToIdMap!!.put("18:00", "37")
        mTimeToIdMap!!.put("18:30", "38")
        mTimeToIdMap!!.put("19:00", "39")
        mTimeToIdMap!!.put("19:30", "40")
        mTimeToIdMap!!.put("20:00", "41")
        mTimeToIdMap!!.put("20:30", "42")
        mTimeToIdMap!!.put("21:00", "43")
        mTimeToIdMap!!.put("21:30", "44")
        mTimeToIdMap!!.put("22:00", "45")
        mTimeToIdMap!!.put("22:30", "46")
        mTimeToIdMap!!.put("23:00", "47")
        mTimeToIdMap!!.put("23:30", "48")
    }

    fun getTime(field: Int, value: Int, format1: String): String {
        val format = SimpleDateFormat(format1)
        val a = GregorianCalendar()
        a.add(field, value)
        return format.format(a.time)
    }

    fun getCurrentTime(): String {
        val min = Integer.parseInt(getTime(Calendar.HOUR_OF_DAY, 0, "m"))
        val hour: String
        val m: String
        if (min >= 0 && min < 30) {
            hour = getTime(Calendar.HOUR_OF_DAY, 0, "HH")
            m = "30"
        } else
        /*if(min >= 30)*/ {
            hour = getTime(Calendar.HOUR_OF_DAY, 1, "HH")
            m = "00"
        }
        val sb = StringBuilder(hour)
        sb.append(":")
        sb.append(m)
        println("time=" + sb.toString())
        return sb.toString()
    }

    fun parseInt(str: String, defaultVal: Int): Int {
        var result = defaultVal
        try {
            result = Integer.parseInt(str)
        } catch (e: NumberFormatException) {
            result = defaultVal
        }
        return result
    }


}