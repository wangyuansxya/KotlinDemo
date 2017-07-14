package kolintdemo.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.wangyuan.kotlindemo.R
import kotlinx.android.synthetic.main.activity_my.*

class MyActivity : AppCompatActivity() {
    var EXTRA_NAME: String = "extra_name";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my);
        getData();

    }

    fun getData() {
        val rece = intent.getStringExtra(EXTRA_NAME);
        mBtnReceive.setText(rece);
    }

}
