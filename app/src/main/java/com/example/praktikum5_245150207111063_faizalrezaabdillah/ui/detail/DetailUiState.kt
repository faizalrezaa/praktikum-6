package com.example.praktikum6_245150207111063_faizalrezaabdillah.ui.detail

import com.example.praktikum6_245150207111063_faizalrezaabdillah.data.model.Student
data class DetailUiState(
    val student: Student? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)