package ua.edu.chnu.kkn.beginningkotlinmultiplatform.ui.screens.timepicker

import androidx.compose.foundation.layout.*
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberTimePickerState
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
fun TimepickerScreen() {
    // State to show/hide the dialog
    var showTimePicker by remember { mutableStateOf(false) }
    // State to store the selected time as a string
    var selectedTime by remember { mutableStateOf("No time selected") }

    // State for the picker itself (defaulting to 12:00, 24-hour format)
    val timePickerState = rememberTimePickerState(
        initialHour = 12,
        initialMinute = 0,
        is24Hour = true
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Time Picker", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Selected Time: $selectedTime",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Button to open the dialog
        Button(onClick = { showTimePicker = true }) {
            Text("Select Time")
        }
    }

    if (showTimePicker) {
        AlertDialog(
            onDismissRequest = {
                showTimePicker = false
                println("Time selection dismissed")
            },
            confirmButton = {
                TextButton(onClick = {
                    showTimePicker = false
                    val hour = timePickerState.hour.toString().padStart(2, '0')
                    val minute = timePickerState.minute.toString().padStart(2, '0')

                    selectedTime = "$hour:$minute"
                    println("Selected time saved: $selectedTime")
                }) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(onClick = {
                    showTimePicker = false
                    println("Time selection cancelled")
                }) {
                    Text("Cancel")
                }
            },
            text = {
                TimePicker(state = timePickerState)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TimePickerScreenPreview() {
    AppTheme {
        Scaffold { paddingValues ->
            Column(modifier = Modifier.padding(paddingValues)) {
                TimepickerScreen()
            }
        }
    }
}