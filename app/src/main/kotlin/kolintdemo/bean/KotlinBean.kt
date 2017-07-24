package kolintdemo.bean

/**
 * Created by wangyuan on 2017/7/12.
 * kotlin定义的数据类，它会自动生成所有属性和它们的访问器，以及一些有用的方法，比如， toString()
 */
data class KotlinBean (
    var id : Int,
    var name : String,
    var desc : String
)