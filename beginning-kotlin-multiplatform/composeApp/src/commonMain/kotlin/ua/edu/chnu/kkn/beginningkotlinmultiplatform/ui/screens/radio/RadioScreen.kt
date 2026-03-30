package ua.edu.chnu.kkn.beginningkotlinmultiplatform.ui.screens.radio

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
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
fun RadioScreen() {
    val radioOptions = listOf("First Option", "Second Option", "Third Option")

    var selectedOption by remember { mutableStateOf(radioOptions[0]) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Radio Buttons", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))

        radioOptions.forEach { optionText ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)

                    .clickable {
                        selectedOption = optionText
                        println("Selected: $optionText")
                    }
            ) {
                RadioButton(
                    selected = (optionText == selectedOption),
                    onClick = {
                        selectedOption = optionText
                        println("Selected via button: $optionText")
                    }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = optionText)
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Currently selected: $selectedOption",
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RadioButtonsScreenPreview() {
    AppTheme {
        Scaffold { paddingValues ->
            Column(modifier = Modifier.padding(paddingValues)) {
                RadioScreen()
            }
        }
    }
}