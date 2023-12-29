package com.example.dasha.homelearncode

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import org.json.JSONException
import org.json.JSONObject

var id_type_learn = 0

class Exercises : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercises)

        // получаем экземпляр элемента ListView
        val listView: ListView = this.findViewById(R.id.exercisesListView)

        var type_learn: String?

        id_type_learn = intent.extras.getInt("position")
        type_learn = intent.extras.getString("type_learn")

        var lessons = ArrayList<String>()

        try {
            val obj = JSONObject(getJsonFromAssets(getApplicationContext(), "yourfilename.json"))
            val m_jArry = obj.getJSONArray(type_learn)

            for (i in 0 until m_jArry.length()) {
                val jo_inside = m_jArry.getJSONObject(i)
                val name_item = jo_inside.getString("menu")
                lessons.add(name_item)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        // используем адаптер данных с типовой разметкой simple_list_item_1
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, lessons)

        listView.onItemClickListener = object : AdapterView.OnItemClickListener {
            override fun onItemClick(
                parent: AdapterView<*>, itemClicked: View, position: Int,
                id: Long
            ) {
                val textView = itemClicked as TextView
                val strText = textView.text.toString() // получаем текст нажатого элемента

                val intent = Intent(this@Exercises, Lesson::class.java)
                intent.putExtra("type_learn", type_learn)
                intent.putExtra("position", position)

                startActivity(intent)
            }
        }

        listView.setAdapter(adapter)

    }
}
