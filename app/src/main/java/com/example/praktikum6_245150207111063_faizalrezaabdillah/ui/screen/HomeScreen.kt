package com.example.praktikum_6_245150207111063_faizalrezaabdillah.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.praktikum_6_245150207111063_faizalrezaabdillah.ui.home.HomeUiState

@Composable
fun HomeScreen(
    uiState: HomeUiState,
    onOpenDetail: (Int) -> Unit,
    onOpenProfile: () -> Unit,
    onOpenAbout: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            "Daftar Mahasiswa",
            style = MaterialTheme.typography.headlineMedium
        )

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(uiState.students) { student ->
                Button(
                    onClick = { onOpenDetail(student.id) }
                ) {
                    Text("${student.id} - ${student.name}")
                }
            }
        }

        OutlinedButton(onClick = onOpenProfile) {
            Text("Buka Profile")
        }

        OutlinedButton(onClick = onOpenAbout) {
            Text("Buka About")
        }
    }
}