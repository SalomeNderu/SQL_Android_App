package com.example.sqlite_android_app_midmorning

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var name_edit: EditText
    lateinit var email_edit: EditText
    lateinit var id_edit: EditText
    lateinit var save_btn: Button
    lateinit var view_btn: Button
    lateinit var delete_btn: Button
    lateinit var db: SQLiteDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        name_edit = findViewById(R.id.edit_name)
        email_edit = findViewById(R.id.edit_email)
        id_edit = findViewById(R.id.edit_id)
        save_btn = findViewById(R.id.save_button)
        view_btn = findViewById(R.id.view_button)
        delete_btn = findViewById(R.id.delete_button)
        //Creating the database
        db = openOrCreateDatabase("nderuhDB", Context.MODE_PRIVATE, null)
        //creating table
        db.execSQL("CREATE TABLE IF NOT EXISTS users(jina VARCHAR, arafa VARCHAR, kitambulisho VARCHAR)")
        save_btn.setOnClickListener {
            var jina_edit = name_edit.text.toString().trim()
            var arafa_edit = email_edit.text.toString().trim()
            var kitambulisho_edit = id_edit.text.toString().trim()
            //validate your edit texts
            if (jina_edit.isEmpty() || arafa_edit.isEmpty() || kitambulisho_edit.isEmpty()) {
                Toast.makeText(this, "Cannot Submit An Empty Field", Toast.LENGTH_SHORT).show()
            } else {
                //Insert Data
                db.execSQL("INSERT INTO users VALUES( '\"+jina_edit+\"',  '\"+arafa_edit+\"',  '\"+kitambulisho_edit+\"')")
                Toast.makeText(this, "Data Saved Successfully", Toast.LENGTH_SHORT).show()
            }

        }
    }
}
