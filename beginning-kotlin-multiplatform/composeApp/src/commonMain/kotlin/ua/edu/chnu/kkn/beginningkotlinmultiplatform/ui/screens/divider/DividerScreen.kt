package ua.edu.chnu.kkn.beginningkotlinmultiplatform.ui.screens.divider // Check if this matches your package

import androidx.compose.foundation.layout.*
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ua.edu.chnu.kkn.beginningkotlinmultiplatform.ui.theme.AppTheme

@Composable
fun DividerScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Dividers", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(24.dp))

        Text("Top Element")


        HorizontalDivider(
            modifier = Modifier.padding(vertical = 16.dp),
            thickness = 2.dp, // Thickness can be adjusted (default is 1.dp)
            color = MaterialTheme.colorScheme.primary // Custom color can be set
        )

        Text("Bottom Element")

        Spacer(modifier = Modifier.height(48.dp))


        Text("A vertical divider is usually used inside a Row:", modifier = Modifier.padding(bottom = 16.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text("Left")
            VerticalDivider(
                modifier = Modifier
                    .height(40.dp)
                    .padding(horizontal = 16.dp),
                thickness = 2.dp,
                color = MaterialTheme.colorScheme.error
            )

            Text("Right")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DividerScreenPreview() {
    AppTheme {
        Scaffold { paddingValues ->
            Column(modifier = Modifier.padding(paddingValues)) {
                DividerScreen()
            }
        }
    }
}