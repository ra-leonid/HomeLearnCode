package com.example.homelearncode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.json.JSONException
import org.json.JSONObject

class Lesson : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson)

        val typeLearn = intent.extras!!.getString("type_learn", "")
        val position = intent.extras!!.getInt("position", 0)

        try {
            val obj = JSONObject(getJsonFromAssets(applicationContext, "yourfilename.json").toString())
            val mjArry = obj.getJSONArray(typeLearn)

            for (i in 0 until mjArry.length()) {
                val joInside = mjArry.getJSONObject(i)
                val idLesson = joInside.getInt("id")

                if(idLesson==position) {
                    val tv1: TextView = findViewById(R.id.lesson_name_textView)
                    tv1.text = joInside.getString("name")

                    val tv2: TextView = findViewById(R.id.lesson_textView)
                    tv2.text = joInside.getString("description")

                    val tv3: TextView = findViewById(R.id.example_textView)
                    tv3.text = joInside.getString("example")

                    break
                }
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }
}