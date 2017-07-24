package kolintdemo.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.wangyuan.kotlindemo.R
import kolintdemo.Dao.Request
import kolintdemo.bean.KotlinBean
import kotlinx.android.synthetic.main.activity_my.*
import org.jetbrains.anko.async
import org.jetbrains.anko.asyncResult
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class MyActivity : AppCompatActivity() {

    companion object {
        var EXTRA_NAME: String = "extra_name";
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my);
        getData();

        //执行一个异步的请求
        async {
            Request("www.baidu.com").run();
            uiThread {  toast("从async回到了mainThread") }
        }

        asyncResult {
            Request("www.baidu.com").run();
            uiThread {  toast("从async回到了mainThread") }
        }

        val bean : KotlinBean = KotlinBean(1, "name", "age");
        val (id, name, age) = bean;
        System.out.print(id.toString().plus(name).plus(age));
    }

    fun getData() {
        val rece = intent.getStringExtra(EXTRA_NAME);
        mBtnReceive.setText(rece);
    }

}
