package ua.edu.chnu.kkn.beginningkotlinmultiplatform.ui.screens._switch

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
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
fun SwitchScreen() {
    // State to hold the current value of the switch
    var isChecked by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Switches", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(24.dp))

        // A Row to place the text and the switch side by side
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween // Pushes text to the left, switch to the right
        ) {
            Text(
                text = if (isChecked) "Wi-Fi is ON" else "Wi-Fi is OFF",
                style = MaterialTheme.typography.bodyLarge
            )

            Switch(
                checked = isChecked,
                onCheckedChange = {
                    isChecked = it
                    println("Switch state changed to: $it") // Log message in English
                },
                // Optional: Adding an icon when the switch is checked (Material 3 feature)
                thumbContent = if (isChecked) {
                    {
                        Icon(
                            imageVector = Icons.Filled.Check,
                            contentDescription = "Checked icon",
                            modifier = Modifier.size(SwitchDefaults.IconSize)
                        )
                    }
                } else {
                    null
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SwitchScreenPreview() {
    AppTheme {
        Scaffold { paddingValues ->
            Column(modifier = Modifier.padding(paddingValues)) {
                SwitchScreen()
            }
        }
    }
}