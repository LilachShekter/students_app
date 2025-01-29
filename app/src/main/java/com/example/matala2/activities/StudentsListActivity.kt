package com.example.matala2.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.Button
import com.example.matala2.R
import com.example.matala2.adapter.StudentAdapter
import com.example.matala2.model.StudentModel
import com.example.matala2.model.Student
import com.google.android.material.floatingactionbutton.FloatingActionButton

class StudentsListActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: StudentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_students_list)

        recyclerView = findViewById(R.id.students_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        updateStudentsList()

        findViewById<Button>(R.id.add_student_button).setOnClickListener {
            val intent = Intent(this, NewStudentActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        updateStudentsList()
    }

    private fun updateStudentsList() {
        adapter = StudentAdapter(StudentModel.getAllStudents()) { student ->
            val intent = Intent(this, StudentDetailsActivity::class.java)
            intent.putExtra("student_id", student.id)
            startActivity(intent)
        }
        recyclerView.adapter = adapter
    }
}