package kolintdemo.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import com.wangyuan.kotlindemo.R
import kolintdemo.MyApp
import kolintdemo.util.MyUtil

/**
 * Created by wangyuan on 2017/7/11.
 */
class TimePickerView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : View(context, attrs, defStyleAttr), View.OnClickListener {

    constructor(context: Context?) : this(context, null, 0){
        init(context);
    }
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0) {
        init(context);
    }

    companion object {
        val TRUE = 1
        val FALSE = 0

        private val APPEND_TIME_ID = 13

        private val STATE_DISABLED = 0;
        private val STATE_SELECTED = 1;
        private val STATE_OPEN = 2;

        private val NUM_COLUMN = 5;

        val TIME_ARRAY = arrayOf(
                arrayOf("06:00", "06:30", "07:00", "07:30", "08:00"),
                arrayOf("08:30", "09:00", "09:30", "10:00", "10:30"),
                arrayOf("11:00", "11:30", "12:00", "12:30", "13:00"),
                arrayOf("13:30", "14:00", "14:30", "15:00", "15:30"),
                arrayOf("16:00", "16:30", "17:00", "17:30", "18:00"),
                arrayOf("18:30", "19:00", "19:30", "20:00", "20:30"),
                arrayOf("21:00", "21:30", "22:00", "22:30", "23:00"),
                arrayOf("23:30"));

    }

    //block
    val mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var yOffset: Int = 0
    var width : Int? = 0;
    var height : Int? = MyUtil.dip2px(50f)


    fun init(context: Context?) {
        mPaint.textAlign = Paint.Align.CENTER
        mPaint.textSize = MyUtil.sp2px(15f)
        val fm = mPaint.fontMetrics
        yOffset = ((fm.descent - fm.ascent) / 2 - fm.descent).toInt()
    }

    private var mLastBlock: Block? = null
    /**
     * 是今天1
     * 不是今天非1
     */
    private var mLastDay = -1

    fun buildBlocks(isToday: Int) {
        mLastDay = isToday
        if (mWidth <= 0) return
        val currentTimeId = MyUtil.getTimeToID(MyUtil.getCurrentTime())
        val timeId = MyUtil.parseInt(currentTimeId, 0)
        Log.e("buildBlocks", "isToday=" + isToday)
        val row = TIME_ARRAY.size
        if (mData == null) mData = ArrayList<Block>(row * NUM_COLUMN)
        val len = mData?.size ?: 0;
        for (i in 0..row - 1) {
            val arr = TIME_ARRAY[i]
            val colmn = arr.size
            for (j in 0..colmn - 1) {
                val b: Block
                val position = i * NUM_COLUMN + j
                if (position < len) {
                    b = mData!!.get(position)
                } else {
                    b = Block()
                    width = mWidth / NUM_COLUMN
                    b.row = i
                    b.column = j
                    b.displayTime = TIME_ARRAY[i][j]
                    b.displayTimeId =  i * NUM_COLUMN + j + APPEND_TIME_ID
                    b.left = width!!.times(j)
                    b.top = height!!.times(i)
                    mData!!.add(b)
                }

                if (isToday == TRUE) {
                    b.state = if (b.displayTimeId < timeId) STATE_DISABLED else STATE_OPEN
                    if (mLastBlock != null) {
                        mLastBlock?.state = if (mLastBlock?.displayTimeId ?: APPEND_TIME_ID < timeId) STATE_DISABLED else STATE_OPEN
                        mLastBlock = null
                    }
                } else {
                    b.state = STATE_OPEN
                }
            }
        }
        invalidate()
    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val width = MyApp.screenWidth
        val len = TIME_ARRAY.size
        val height = height!!.times(len);
        setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(width, View.MeasureSpec.AT_MOST), View.MeasureSpec.makeMeasureSpec(height, View.MeasureSpec.AT_MOST))
    }


    var mWidth: Int = 0;
    var mHeight: Int = 0;

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        if(mWidth <= 0 || mHeight <= 0) {
            mWidth = right - left;
            mHeight = bottom - top;
            width = mWidth / NUM_COLUMN;
            buildBlocks(mLastDay)
        }
    }

    private var mData: MutableList<Block>? = null;

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (canvas == null || mData == null || mData!!.size == 0) return
        for (b in mData!!) {
            b.draw(canvas)
        }
    }

    inner class Block {

        var state = STATE_OPEN;

        var column: Int = 0
        var row: Int = 0

        var left: Int = 0
        var top: Int = 0

        var displayTime : String = "6:00"
        var displayTimeId : Int = 0

        fun draw(canvas: Canvas) {
            when (state) {
                STATE_OPEN -> {
                    mPaint.color = resources.getColor(R.color.color_FFFFFF);
                    canvas.drawRect(left.toFloat(), top.toFloat(), (width!!.plus(left)).toFloat(), (height!!.plus(top)).toFloat(), mPaint)
                    mPaint.color = resources.getColor(R.color.color_666666);
                    canvas.drawText(displayTime, (left + width!!.div(2)).toFloat(), (top + height!!.div(2) + yOffset).toFloat(), mPaint)
                }
                STATE_SELECTED -> {
                    mPaint.color = resources.getColor(R.color.color_424242);
                    canvas.drawRect(left.toFloat(), top.toFloat(), (width!!.plus(left)).toFloat(), (height!!.plus(top)).toFloat(), mPaint)
                    mPaint.color = resources.getColor(R.color.color_FFFFFF);
                    canvas.drawText(displayTime, (left + width!!.div(2)).toFloat(), (top + (height!!.div(2)) + yOffset).toFloat(), mPaint)
                }

                STATE_DISABLED -> {
                    mPaint.color = resources.getColor(R.color.color_FFFFFF);
                    canvas.drawRect(left.toFloat(), top.toFloat(), (width!!.plus(left)).toFloat(), (height!!.plus(top)).toFloat(), mPaint)
                    mPaint.color = resources.getColor(R.color.color_C7C7C7);
                    canvas.drawText(displayTime, (left + width!!.div(2)).toFloat(), (top + height!!.div(2) + yOffset).toFloat(), mPaint)
                }
            }
        }
    }


    private var mLastX = 0f;
    private var mLastY = 0f;

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when(event?.actionMasked) {
                MotionEvent.ACTION_UP -> {
                    mLastX = event?.x;
                    mLastY = event?.y;
                }
        }
        return super.onTouchEvent(event)
    }

    private fun findBlock(blocks: List<Block>?, x: Float, y: Float): Int {
        if (blocks == null || blocks.size <= 0) {
            return -1
        }
        val row = y.toInt().div(height!!);
        val column = x.toInt().div(width!!);
        return row * NUM_COLUMN + column
    }

    override fun onClick(view: View) {
        val index = findBlock(mData, mLastX, mLastY)
        val len = if (mData == null) -1 else mData!!.size
        if (index < 0 || index >= len) return
        val b = mData!!.get(index)
        val currentTimeId = MyUtil.getTimeToID(MyUtil.getCurrentTime())
        val timeId = MyUtil.parseInt(currentTimeId, 0)
        if (mLastDay == TRUE && b.displayTimeId < timeId) {
            Toast.makeText(this.context, "当前时间已过", Toast.LENGTH_SHORT).show()
        } else {
            if (b.state == STATE_DISABLED || b.state == STATE_SELECTED) return
            if (mLastBlock != null && mLastBlock!!.state == STATE_SELECTED) mLastBlock!!.state = STATE_OPEN
            b.state = STATE_SELECTED
            mLastBlock = b
            invalidate()
            if (mCallBack != null) mCallBack!!.onItemTimeSelect(b.displayTimeId, b.displayTime)
        }
    }

    private var mCallBack: OnItemSelected? = null

    fun setCallBack(callBack: OnItemSelected) {
        this.mCallBack = callBack
    }

    interface OnItemSelected {
        fun onItemTimeSelect(timeId: Int, time: String)
    }

}
