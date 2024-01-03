package com.example.homelearncode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.content.Intent
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import org.json.JSONException
import org.json.JSONObject

class Exercises : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercises)

        // получаем экземпляр элемента ListView
        val listView: ListView = this.findViewById(R.id.exercisesListView)

        val typeLearn = intent.extras!!.getString("type_learn", "")

        val lessons = ArrayList<String>()

        try {
            val obj = JSONObject(getJsonFromAssets(applicationContext, "yourfilename.json").toString())
            val mjArry = obj.getJSONArray(typeLearn)

            for (i in 0 until mjArry.length()) {
                val joInside = mjArry.getJSONObject(i)
                val nameItem = joInside.getString("menu")
                lessons.add(nameItem)
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

                val intent = Intent(this@Exercises, Lesson::class.java)
                intent.putExtra("type_learn", typeLearn)
                intent.putExtra("position", position)

                startActivity(intent)
/*
                Toast.makeText(
                    //applicationContext, position.toString(),
                    applicationContext, type_learn,
                    Toast.LENGTH_SHORT
                ).show()
*/
            }
        }

        listView.adapter = adapter

    }
}