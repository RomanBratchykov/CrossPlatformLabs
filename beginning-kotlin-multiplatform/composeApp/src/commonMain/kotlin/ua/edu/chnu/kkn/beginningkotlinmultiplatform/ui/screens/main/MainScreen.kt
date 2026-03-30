package ua.edu.chnu.kkn.beginningkotlinmultiplatform.ui.screens.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import beginningkotlinmultiplatform.composeapp.generated.resources.Res
import beginningkotlinmultiplatform.composeapp.generated.resources.buttons
import org.jetbrains.compose.resources.stringResource
import beginningkotlinmultiplatform.composeapp.generated.resources.checkboxes
import beginningkotlinmultiplatform.composeapp.generated.resources.chips
import beginningkotlinmultiplatform.composeapp.generated.resources.datepicker
import beginningkotlinmultiplatform.composeapp.generated.resources.switch
import beginningkotlinmultiplatform.composeapp.generated.resources.timepicker
import beginningkotlinmultiplatform.composeapp.generated.resources.dialog
import beginningkotlinmultiplatform.composeapp.generated.resources.divider
import beginningkotlinmultiplatform.composeapp.generated.resources.progressbar
import beginningkotlinmultiplatform.composeapp.generated.resources.radio

@Composable
fun MainScreen(
    onButtonsClicked: () -> Unit,
    onCheckboxesClicked: () -> Unit,
    onChipsClicked: () -> Unit,
    onDatepickerClicked: () -> Unit,
    onDialogClicked: () -> Unit,
    onDividerClicked: () -> Unit,
    onProgressClicked: () -> Unit,
    onRadioClicked: () -> Unit,
    onSwitchClicked: () -> Unit,
    onTimepickerClicked: () -> Unit,
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                onButtonsClicked()
            }
        ) {
            Text(stringResource(Res.string.buttons))
        }

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                onCheckboxesClicked()
            }
        ) {
            Text(stringResource(Res.string.checkboxes))
        }

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                onChipsClicked()
            }
        ) {
            Text(stringResource(Res.string.chips))
        }

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                onDatepickerClicked()
            }
        ) {
            Text(stringResource(Res.string.datepicker))
        }

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                onDialogClicked()
            }
        ) {
            Text(stringResource(Res.string.dialog))
        }

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                onProgressClicked()
            }
        ) {
            Text(stringResource(Res.string.progressbar))
        }

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                onDividerClicked()
            }
        ) {
            Text(stringResource(Res.string.divider))
        }

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                onRadioClicked()
            }
        ) {
            Text(stringResource(Res.string.radio))
        }

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                onSwitchClicked()
            }
        ) {
            Text(stringResource(Res.string.switch))
        }

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                onTimepickerClicked()
            }
        ) {
            Text(stringResource(Res.string.timepicker))
        }

    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen(
        onButtonsClicked = {},
        onCheckboxesClicked = {},
        onChipsClicked = {},
        onDatepickerClicked = {},
        onDialogClicked = {},
        onDividerClicked = {},
        onProgressClicked = {},
        onRadioClicked = {},
        onSwitchClicked = {},
        onTimepickerClicked = {},
    )
}