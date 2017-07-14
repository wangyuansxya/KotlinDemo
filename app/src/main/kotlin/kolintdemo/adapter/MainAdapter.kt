package kolintdemo.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.wangyuan.kotlindemo.R
import kolintdemo.bean.KotlinBean

/**
 * Created by wangyuan on 2017/7/12.
 */
class MainAdapter() : RecyclerView.Adapter<MainAdapter.MyViewHolder>() {

    var data : List<KotlinBean>? = null;
    var mContext : Context? = null;

    constructor(context : Context?) : this(){
        mContext = context;
    }

    constructor(context : Context?, data : List<KotlinBean>?) : this(context){
        this.mContext = context;
        this.data = data;
        Log.d("MainAdapter", "getItemCount=" + data)
    }

    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {
        var bean : KotlinBean?  = data!!.get(position);
        holder!!.tvItem = holder!!.itemView.findViewById(R.id.list_item) as TextView;
        var sb : StringBuilder = StringBuilder("name =");
        sb.append(bean!!.name);
        sb.append("  age=");
        sb.append(bean.age);

        holder!!.tvItem!!.setText(sb.toString());
        /*var tv = (holder!!.itemView);
        if(tv is TextView) {
            tv.setText(bean);
        }*/
        Log.d("MainAdapter", "onBindViewHolder")
    }

    override fun getItemCount(): Int {
        Log.d("MainAdapter", "getItemCount=" + data!!.size)
        return data!!.size;
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {
        var item : View? = LayoutInflater.from(mContext).inflate(R.layout.item_main_adapter, null, false);
        var param : ViewGroup.LayoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        item!!.layoutParams = param;
        return MyViewHolder(item);
    }

    inner class MyViewHolder(itemView : View?) : RecyclerView.ViewHolder(itemView) {
        var tvItem : TextView? = null;
    }


}