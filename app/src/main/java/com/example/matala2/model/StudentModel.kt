package com.example.matala2.model

object StudentModel {
    private val studentsList = mutableListOf<Student>()

    fun getAllStudents() = studentsList

    fun addStudent(student: Student) {
        studentsList.add(student)
    }

    fun getStudentById(id: String) = studentsList.find { it.id == id}

    fun updateStudent(updateStudent: Student) {
        val index = studentsList.indexOfFirst { it.id == updateStudent.id }
        if (index != -1) {
            studentsList[index] = updateStudent
        }
    }

    fun deleteStudent(id: String) {
        studentsList.removeIf { it.id == id }

    }

}