package com.example.matala2.activities


import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.matala2.R
import com.example.matala2.model.Student
import com.example.matala2.model.StudentModel


class EditStudentActivity : AppCompatActivity() {
    private lateinit var nameEdit: EditText
    private lateinit var idEdit: EditText
    private lateinit var phoneEdit: EditText
    private lateinit var addressEdit: EditText
    private lateinit var checkedCheckbox: CheckBox
    private var originalId: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_student)

        nameEdit = findViewById(R.id.name_edit)
        idEdit = findViewById(R.id.id_edit)
        phoneEdit = findViewById(R.id.phone_edit)
        addressEdit = findViewById(R.id.address_edit)
        checkedCheckbox = findViewById(R.id.checked_checkbox)

        val studentId = intent.getStringExtra("student_id")
        originalId = studentId ?: ""

        StudentModel.getStudentById(originalId)?.let {
            nameEdit.setText(it.name)
            idEdit.setText(it.id)
            phoneEdit.setText(it.phone)
            addressEdit.setText(it.address)
            checkedCheckbox.isChecked = it.isChecked
        }

        findViewById<Button>(R.id.save_button).setOnClickListener {
            saveStudent()
            finish()
        }

        findViewById<Button>(R.id.delete_button).setOnClickListener {
            StudentModel.deleteStudent(originalId)
            finish()
        }

        findViewById<Button>(R.id.cancel_button).setOnClickListener {
            finish()
        }
    }

    private fun saveStudent() {
        val updatedStudent = Student(
            id = idEdit.text.toString(),
            name = nameEdit.text.toString(),
            phone = phoneEdit.text.toString(),
            address = addressEdit.text.toString(),
            isChecked = checkedCheckbox.isChecked
        )

        if (originalId.isEmpty()) {
            StudentModel.addStudent(updatedStudent)
        } else {
            StudentModel.updateStudent(updatedStudent)
        }
    }
}