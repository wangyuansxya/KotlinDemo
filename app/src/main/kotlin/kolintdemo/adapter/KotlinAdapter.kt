package kolintdemo.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup

/**
 * Created by wangyuan on 2017/7/12.
 */
open class KotlinAdapter() : RecyclerView.Adapter<KotlinAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

    }

    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

    }

    inner class MyViewHolder(itemView : View?) : RecyclerView.ViewHolder(itemView) {
    }

}