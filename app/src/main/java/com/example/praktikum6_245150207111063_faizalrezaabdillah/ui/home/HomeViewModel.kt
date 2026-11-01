package com.example.praktikum6_245150207111063_faizalrezaabdillah.ui.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.praktikum_6_245150207111063_faizalrezaabdillah.data.repository.StudentRepository
import com.example.praktikum_6_245150207111063_faizalrezaabdillah.ui.home.HomeUiState

class HomeViewModel(
    private val repository: StudentRepository
) : ViewModel() {

    var uiState by mutableStateOf(HomeUiState())
        private set

    fun loadStudents() {
        val students = repository.getStudents()
        uiState = HomeUiState(students = students)
    }

    companion object {
        fun factory(repository: StudentRepository): ViewModelProvider.Factory =
            object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return HomeViewModel(repository) as T
                }
            }
    }
}