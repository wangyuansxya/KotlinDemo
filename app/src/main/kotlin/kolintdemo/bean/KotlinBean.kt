package kolintdemo.bean

import org.json.JSONObject

/**
 * Created by wangyuan on 2017/7/12.
 * kotlin定义的数据类，它会自动生成所有属性和它们的访问器，以及一些有用的方法，比如， toString()
 */
data class KotlinBean (
    var id : Int,
    var name : String,
    var desc : String) {
    constructor() : this(0, "", ""){
    }

    companion object {
        val ID_0 = 0;
        val ID_1 = 1;
        val ID_2 = 2;
    }

    fun parse(o : JSONObject) : KotlinBean {
        var bean : KotlinBean = KotlinBean();
        bean.id = o.optInt("id");
        bean.name = o.optString("name");
        bean.desc = o.optString("desc");
        return bean;
    }
}