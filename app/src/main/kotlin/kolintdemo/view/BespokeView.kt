package kolintdemo.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import kolintdemo.util.MyUtil

/**
 * Created by wangyuan on 2017/7/11.
 */
class BespokeView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : View(context, attrs, defStyleAttr) {
    constructor(context: Context?) : this(context, null, 0){}
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0) {}

    val TIME_ARR = arrayOf(
            arrayOf("06:00", "06:30", "07:00", "07:30", "08:00"),
            arrayOf("08:30", "09:00", "09:30", "10:00", "10:30"),
            arrayOf("11:00", "11:30", "12:00", "12:30", "13:00"),
            arrayOf("13:30", "14:00", "14:30", "15:00", "15:30"),
            arrayOf("16:00", "16:30", "17:00", "17:30", "18:00"),
            arrayOf("18:30", "19:00", "19:30", "20:00", "20:30"),
            arrayOf("21:00", "21:30", "22:00", "22:30", "23:00"),
            arrayOf("23:30"));

    val NUM_COLUMN = 5;

    var mWidth: Int = 0;
    var mHeight: Int = 0;

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        if(mWidth <= 0 || mHeight <= 0) {
            mWidth = right - left;
            mHeight = bottom - top;
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

    }

    inner class Block {

        private val STATE_DISABLED = 0;
        private val STATE_SELECTED = 1;
        private val STATE_OPEN = 2;
        val mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        var state = STATE_OPEN;
        var width = mWidth / NUM_COLUMN;
//        var myUtil : MyUtil? = MyUtil();
        val height : Int? = MyUtil.dip2px(50f)
    }

    private var mLastX = 0f;
    private var mLastY = 0f;

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when(event?.actionMasked) {
                MotionEvent.ACTION_UP -> {
                    mLastX = event.x;
                    mLastY = event.y;
                }
        }
        return super.onTouchEvent(event)
    }

}