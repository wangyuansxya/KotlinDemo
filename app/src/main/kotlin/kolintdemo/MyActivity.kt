package kolintdemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.wangyuan.kotlindemo.R

class MyActivity : AppCompatActivity() {
    var EXTRA_NAME: String = "extra_name";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my)
    }

    fun getData() {
        intent.getStringExtra(EXTRA_NAME);
    }
}
