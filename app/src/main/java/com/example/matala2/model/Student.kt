package com.example.matala2.model

data class Student(
    var id: String,
    var name: String,
    var phone: String,
    var address: String,
    var isChecked: Boolean = false,
    var imageUrl: String = "drawable/avatar"
)