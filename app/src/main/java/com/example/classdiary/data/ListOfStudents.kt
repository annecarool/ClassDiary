package com.example.classdiary.data

import com.example.classdiary.model.Student

class ListOfStudents {

    fun loadListOfStudents():List<Student> {
        return listOf<Student>(
            Student("Carl Johnson", "Protagonist"),
            Student("Ryder", "Major Characters"),
            Student("Kendl Johnson","Major Characters"),
            Student("Big Smoke", "Major Characters"),
            Student("Sweet", "Major Characters")
        )

    }
}