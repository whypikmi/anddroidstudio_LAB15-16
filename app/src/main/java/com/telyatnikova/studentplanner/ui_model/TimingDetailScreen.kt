package com.telyatnikova.studentplanner.ui_model

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.telyatnikova.studentplanner.data.sampleTiming

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimingDetailScreen(
    timingId: String,
    onNavigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    val timingItem = sampleTiming.find { it.id == timingId }
    if (timingItem == null) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = androidx.compose.ui.Alignment.Center
        ) {
            Text("Занятие не найдено")
        }
        return
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Детали занятия") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Назад"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = timingItem.dayOfWeek,
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = timingItem.time,
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }

            Card(modifier = Modifier.fillMaxWidth()) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    DetailRow(
                        label = "Дисциплина",
                        value = timingItem.subjectName
                    )
                    HorizontalDivider()
                    DetailRow(
                        label = "Преподаватель",
                        value = timingItem.professor
                    )
                    HorizontalDivider()
                    DetailRow(
                        label = "Аудитория",
                        value = timingItem.classroom
                    )
                }
            }
        }
    }
}