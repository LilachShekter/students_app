package com.example.matala2.activities

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.matala2.R
import com.example.matala2.model.Student
import com.example.matala2.model.StudentModel



class NewStudentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_student)

        findViewById<Button>(R.id.save_button).setOnClickListener {
            val newStudent = Student(
                id = findViewById<EditText>(R.id.id_edit).text.toString(),
                name = findViewById<EditText>(R.id.name_edit).text.toString(),
                phone = findViewById<EditText>(R.id.phone_edit).text.toString(),
                address = findViewById<EditText>(R.id.address_edit).text.toString(),
                isChecked = findViewById<CheckBox>(R.id.checked_checkbox).isChecked
            )
            StudentModel.addStudent(newStudent)
            finish()
        }

        findViewById<Button>(R.id.cancel_button).setOnClickListener {
            finish()
        }
    }
}