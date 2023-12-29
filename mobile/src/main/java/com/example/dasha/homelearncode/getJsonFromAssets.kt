package com.example.dasha.homelearncode

import android.content.Context
import java.io.IOException
import java.nio.charset.Charset


fun getJsonFromAssets(context: Context, fileName: String): String? {
    val jsonString: String
    try {
        val `is` = context.getAssets().open(fileName)

        val size = `is`.available()
        val buffer = ByteArray(size)
        `is`.read(buffer)
        `is`.close()

        jsonString = String(buffer, Charset.forName("UTF-8"))
    } catch (e: IOException) {
        e.printStackTrace()
        return null
    }

    return jsonString
}
