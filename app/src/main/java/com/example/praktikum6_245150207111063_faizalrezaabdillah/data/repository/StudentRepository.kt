package com.example.praktikum_6_245150207111063_faizalrezaabdillah.data.repository

import com.example.praktikum6_245150207111063_faizalrezaabdillah.data.model.Student
import com.example.praktikum6_245150207111063_faizalrezaabdillah.data.source.StudentLocalDataSource



interface StudentRepository {
    fun getStudents(): List<Student>
    fun getStudentById(id: Int): Student?
}

class DefaultStudentRepository(
    private val dataSource: StudentLocalDataSource
) : StudentRepository {
    override fun getStudents(): List<Student> =
        dataSource.getStudents()

    override fun getStudentById(id: Int): Student? =
        dataSource.getStudentById(id)
}