package ua.edu.chnu.kkn.beginningkotlinmultiplatform.ui.screens.chips

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AssistChip
import androidx.compose.material3.FilterChip
import androidx.compose.material3.InputChip
import androidx.compose.foundation.layout.*
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.material3.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ua.edu.chnu.kkn.beginningkotlinmultiplatform.ui.theme.AppTheme

@Composable
fun ChipsScreen() {

    var isFilterSelected by remember { mutableStateOf(false) }
    var isInputChipVisible by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier.fillMaxSize()
            .padding(16.dp)
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                "Chips"
            )

            AssistChip(
                onClick = { println("Assist chip pressed") },
                label = { Text("Assist chip") },
                leadingIcon = {
                    Icon(
                        Icons.Filled.Settings,
                        contentDescription = "Localized description",
                        Modifier.size(AssistChipDefaults.IconSize)
                    )
                }
            )
            FilterChip(
                onClick = { isFilterSelected = !isFilterSelected },
                label = {
                    Text("Filter chip")
                },
                selected = isFilterSelected,
                leadingIcon = if (isFilterSelected) {
                    {
                        Icon(
                            imageVector = Icons.Filled.Done,
                            contentDescription = "Done icon",
                            modifier = Modifier.size(FilterChipDefaults.IconSize)
                        )
                    }
                } else {
                    null
                },
            )
            SuggestionChip(
                onClick = { println("Suggestion chip pressed") },
                label = { Text("Suggestion chip") }
            )

            var enabled by remember { mutableStateOf(true) }
            if (!enabled) return

            if (isInputChipVisible) { // Показуємо тільки якщо стан true
                InputChip(
                    selected = false,
                    onClick = {
                        // Імітуємо видалення чіпа при натисканні
                        isInputChipVisible = false
                    },
                    label = { Text("Input chip") },
                    avatar = {
                        Icon(
                            imageVector = Icons.Filled.Person,
                            contentDescription = "Аватар",
                            modifier = Modifier.size(InputChipDefaults.AvatarSize)
                        )
                    },
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Закрити",
                            modifier = Modifier.size(InputChipDefaults.AvatarSize)
                        )
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun ChipsScreenPreview() {
    AppTheme {
        Scaffold {
            ChipsScreen()
        }
    }
}