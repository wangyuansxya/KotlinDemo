package kolintdemo.activity

import android.os.Bundle
import com.wangyuan.kotlindemo.R
import kotlinx.android.synthetic.main.activity_fragment_my.*

/**
 * Created by wangyuan on 2017/7/14.
 */
class MyFragmentActivity : BaseKotlinFragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_my);
        mTvFragmentTitle.setText(intent.getStringExtra(MyActivity.EXTRA_NAME));
    }

}