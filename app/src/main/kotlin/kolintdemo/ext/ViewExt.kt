package kolintdemo.ext

import android.content.Context
import android.view.View
import android.widget.TextView
import org.jetbrains.anko.textColor

/**
 * Created by wangyuan on 2017/7/25.
 * 拓展属性
 */
val View.ctx : Context
    get() = context;

var TextView.textColor : Int
    get() = textColor;
    //set(value) {textColor = value};
    set(value) = setTextColor(value);

