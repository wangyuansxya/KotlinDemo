package com.wangyuan.kotlinmix

/**
 * Created by wangyuan on 2017/5/19.
 */

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.wangyuan.kotlindemo.R
import com.wangyuan.kotlindemo.models.Todo
import io.realm.Realm
import org.jetbrains.anko.*
import org.jetbrains.anko.support.v4.UI
import org.jetbrains.anko.support.v4.find
import java.util.*

class EditFragment : Fragment() {

    val TODO_ID_KEY: String = "todo_id_key"

    val realm: Realm = Realm.getDefaultInstance()

    var todo: Todo? = null

    companion object {
        fun newInstance(id: String): EditFragment {
            var args: Bundle = Bundle()
            args.putString("todo_id_key", id)
            var editFragment: EditFragment = newInstance()
            editFragment.arguments = args
            return editFragment
        }

        fun newInstance(): EditFragment {
            return EditFragment()
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if(arguments != null && arguments.containsKey(TODO_ID_KEY)) {
            val todoId = arguments.getString(TODO_ID_KEY)
            todo = realm.where(Todo::class.java).equalTo("id", todoId).findFirst()
            val todoTitle = find<EditText>(R.id.todo_title)
            todoTitle.setText(todo?.title)
            val todoDesc = find<EditText>(R.id.todo_desc)
            todoDesc.setText(todo?.description)
            val add = find<Button>(R.id.todo_add)
            add.setText(R.string.save)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }

    /**
     *  A private function to create a TODO item in the database (Realm).
     *
     *  @param title the title edit text.
     *  @param desc the description edit text.
     */
    private fun createTodoFrom(title: EditText, desc: EditText) {
        realm.beginTransaction()

        // Either update the edited object or create a new one.
        var t = todo?: realm.createObject(Todo::class.java)
        t.id = todo?.id?: UUID.randomUUID().toString()
        t.title = title.text.toString()
        t.description = desc.text.toString()
        realm.commitTransaction()

        // Go back to previous activity
        activity.supportFragmentManager.popBackStack();
    }

}