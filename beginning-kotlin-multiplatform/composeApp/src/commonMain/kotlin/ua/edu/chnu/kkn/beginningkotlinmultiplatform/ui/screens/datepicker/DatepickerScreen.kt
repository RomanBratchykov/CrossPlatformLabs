package ua.edu.chnu.kkn.beginningkotlinmultiplatform.ui.screens.datepicker

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ua.edu.chnu.kkn.beginningkotlinmultiplatform.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerModal(
    onDateSelected: (Long?) -> Unit,
    onDismiss: () -> Unit
) {
    val datePickerState = rememberDatePickerState()

    DatePickerDialog(
        onDismissRequest = {
            onDismiss()
            println("Date picker dismissed by user")
        },
        confirmButton = {
            TextButton(onClick = {
                onDateSelected(datePickerState.selectedDateMillis)
                onDismiss()
            }) {
                Text("OK")
            }
        },
        dismissButton = {
            TextButton(onClick = {
                onDismiss()
                println("Date picker cancelled")
            }) {
                Text("Cancel")
            }
        }
    ) {
        DatePicker(state = datePickerState)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatepickerScreen() {
    var showDatePicker by remember { mutableStateOf(false) }
    var selectedDateMillis by remember { mutableStateOf<Long?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Date Picker", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick = {
            showDatePicker = true
            println("Date picker opened")
        }) {
            Text("Open Date Picker")
        }

        if (selectedDateMillis != null) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Selected Date (Millis): $selectedDateMillis",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.primary
            )
        }

        if (showDatePicker) {
            DatePickerModal(
                onDateSelected = { millis ->
                    selectedDateMillis = millis
                    println("Date selected: $millis")
                },
                onDismiss = {
                    showDatePicker = false
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DatepickerScreenPreview() {
    AppTheme {
        Scaffold { paddingValues ->
            Column(modifier = Modifier.padding(paddingValues)) {
                DatepickerScreen()
            }
        }
    }
}