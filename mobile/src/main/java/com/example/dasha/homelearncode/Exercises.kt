package com.example.dasha.homelearncode

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.ListView


class Exercises : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercises)

        // получаем экземпляр элемента ListView
        val listView: ListView = findViewById(R.id.exercisesListView)

        // определяем строковый массив
        val catNames = resources.getStringArray(R.array.cat_names)
        /*
        val catNames = arrayOf(
            "Рыжик",
            "Барсик",
            "Мурзик",
            "Мурка",
            "Васька",
            "Томасина",
            "Кристина",
            "Пушок",
            "Дымка",
            "Кузя",
            "Китти",
            "Масяня",
            "Симба"
        )
        */

        // используем адаптер данных с типовой разметкой simple_list_item_1
//        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, catNames)
        //val adapter = ArrayAdapter(this, android.R.layout.activity_list_item, catNames)

        // используем адаптер данных с собственной разметкой из файла list_item
        val adapter = ArrayAdapter(this, R.layout.list_item, catNames)

        listView.setAdapter(adapter)

    }
}
