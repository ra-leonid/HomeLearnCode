package com.example.homelearncode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.content.Intent
import android.view.View
import android.widget.*
import android.widget.TextView
import android.widget.AdapterView

class TypeLearn : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_type_learn)

        // определяем строковый массив
        val typeLearn = resources.getStringArray(R.array.type_learn)

        // используем адаптер данных с типовой разметкой simple_list_item_1
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, typeLearn)

        // получаем экземпляр элемента ListView
        val listView: ListView = findViewById(R.id.typeLearnListView)

        listView.adapter = adapter

        listView.onItemClickListener = object : AdapterView.OnItemClickListener {
            override fun onItemClick(
                parent: AdapterView<*>, itemClicked: View, position: Int,
                id: Long
            ) {
                val textView = itemClicked as TextView
                val strText = textView.text.toString() // получаем текст нажатого элемента

                /*
                Toast.makeText(
                    applicationContext, (itemClicked as TextView).text,
                    Toast.LENGTH_SHORT
                ).show()

                Toast.makeText(
                    applicationContext, position.toString(),
                    Toast.LENGTH_SHORT
                ).show()
                */

                val intent = Intent(this@TypeLearn, Exercises::class.java)
                intent.putExtra("type_learn", strText)
                intent.putExtra("position", position)

                startActivity(intent)
            }
        }
    }
}