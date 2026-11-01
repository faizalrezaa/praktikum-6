package com.example.praktikum5_245150207111063_faizalrezaabdillah

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.praktikum5_245150207111063_faizalrezaabdillah.ui.navigation.NavigationLabApp
import com.example.praktikum5_245150207111063_faizalrezaabdillah.ui.theme.Praktikum5_245150207111063_FaizalRezaAbdillahTheme as NavigationLabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationLabTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    NavigationLabApp()
                }
            }
        }
    }
}