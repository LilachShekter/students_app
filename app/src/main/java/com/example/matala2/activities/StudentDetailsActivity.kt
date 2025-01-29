package com.example.matala2.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.matala2.R
import com.example.matala2.model.StudentModel

class StudentDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_details)

        val studentId = intent.getStringExtra("student_id")
        val student = StudentModel.getStudentById(studentId!!)

        student?.let {
            findViewById<TextView>(R.id.name_text).text = "name: ${it.name}"
            findViewById<TextView>(R.id.id_text).text = "id: ${it.id}"
            findViewById<TextView>(R.id.phone_text).text = "phone: ${it.phone}"
            findViewById<TextView>(R.id.address_text).text = "address: ${it.address}"
            findViewById<CheckBox>(R.id.checked_checkbox).isChecked = it.isChecked
        }

        findViewById<Button>(R.id.edit_button).setOnClickListener {
            val intent = Intent(this, EditStudentActivity::class.java)
            intent.putExtra("student_id", studentId)
            startActivity(intent)
        }
    }
}