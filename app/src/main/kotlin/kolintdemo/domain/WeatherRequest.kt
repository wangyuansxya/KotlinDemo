package kolintdemo.domain

import kolintdemo.Dao.Request
import kolintdemo.bean.KotlinBean

/**
 * Created by wangyuan on 2017/7/24.
 */
class WeatherRequest : Command<KotlinBean> {

    override fun execute(): KotlinBean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val r : Request = Request("1001");
        val bean : KotlinBean = r.run();
        return bean;
    }
}