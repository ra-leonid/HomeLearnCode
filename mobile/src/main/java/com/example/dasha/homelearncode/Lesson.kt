package com.example.dasha.homelearncode


import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.json.JSONException
import org.json.JSONObject


class Lesson : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson)

        var type_learn = intent.extras.getString("type_learn", "")
        var position = intent.extras.getInt("position", 0)

        try {
            val obj = JSONObject(getJsonFromAssets(getApplicationContext(), "yourfilename.json"))
            val m_jArry = obj.getJSONArray(type_learn)
            //val formList = ArrayList<HashMap<String, String>>()
            //var m_li: HashMap<String, String>

            for (i in 0 until m_jArry.length()) {
                val jo_inside = m_jArry.getJSONObject(i)
                val id_lesson = jo_inside.getInt("id")

                if(id_lesson==position) {
                    val lesson_name_value = jo_inside.getString("name")
                    val description_value = jo_inside.getString("description")
                    val example_value = jo_inside.getString("example")


                    val tv1: TextView = findViewById(R.id.lesson_name_textView)
                    tv1.text = lesson_name_value

                    val tv2: TextView = findViewById(R.id.lesson_textView)
                    tv2.text = description_value

                    val tv3: TextView = findViewById(R.id.example_textView)
                    tv3.text = example_value

                    break
                }
/*
                //Add your values in your `ArrayList` as below:
                m_li = HashMap()
                m_li["formule"] = formula_value
                m_li["url"] = url_value

                formList.add(m_li)

                Toast.makeText(
                    applicationContext, formula_value,
                    Toast.LENGTH_SHORT
                ).show()

*/

            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }


}