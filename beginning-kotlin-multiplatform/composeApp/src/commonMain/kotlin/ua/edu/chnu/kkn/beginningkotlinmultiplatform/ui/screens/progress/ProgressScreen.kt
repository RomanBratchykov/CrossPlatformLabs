package ua.edu.chnu.kkn.beginningkotlinmultiplatform.ui.screens.progress

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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

@Composable
fun ProgressScreen() {
    // State to hold the current progress value (from 0.0 to 1.0)
    var currentProgress by remember { mutableStateOf(0.0f) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally // Centers everything horizontally
    ) {
        Text("Progress Indicators", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(32.dp))

        // --- Indeterminate Progress (Endless loading) ---
        Text("Indeterminate (Loading...)", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(16.dp))

        // Circular endless loading
        CircularProgressIndicator()
        Spacer(modifier = Modifier.height(16.dp))
        // Linear endless loading
        LinearProgressIndicator(modifier = Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.height(48.dp))

        // --- Determinate Progress (Specific value) ---
        Text("Determinate (Specific progress)", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(16.dp))

        // Circular progress with specific value
        CircularProgressIndicator(progress = { currentProgress })
        Spacer(modifier = Modifier.height(16.dp))
        // Linear progress with specific value
        LinearProgressIndicator(
            progress = { currentProgress },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Button to simulate progress increasing
        Button(
            onClick = {
                if (currentProgress < 1.0f) {
                    currentProgress += 0.1f // Add 10%
                } else {
                    currentProgress = 0.0f // Reset back to 0%
                }
                println("Current progress changed to: $currentProgress") // English log
            }
        ) {
            Text(if (currentProgress >= 1.0f) "Reset Progress" else "Increase Progress (+10%)")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProgressScreenPreview() {
    AppTheme {
        Scaffold { paddingValues ->
            Column(modifier = Modifier.padding(paddingValues)) {
                ProgressScreen()
            }
        }
    }
}