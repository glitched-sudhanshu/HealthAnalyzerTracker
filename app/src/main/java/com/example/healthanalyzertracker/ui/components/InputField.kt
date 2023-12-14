package com.example.healthanalyzertracker.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.healthanalyzertracker.ui.theme.DarkPaleBlue
import com.example.healthanalyzertracker.ui.theme.LightPaleBlue
import com.example.healthanalyzertracker.ui.theme.PlaypenSans

@Composable
fun InputField(
  text: String,
  label: String,
  modifier: Modifier = Modifier,
  onTextChange: (String) -> Unit
) {
  var fieldText by remember { mutableStateOf(TextFieldValue(text)) }
  OutlinedTextField(
    value = fieldText,
    onValueChange = {
      fieldText = it
      onTextChange(it.text) },
    label = { Text(label) },
    keyboardOptions = KeyboardOptions.Default.copy(
      keyboardType = KeyboardType.Number,
    ),
    shape = RoundedCornerShape(15.dp),
    modifier = modifier.fillMaxWidth(),
    textStyle = TextStyle(
      fontFamily = PlaypenSans.regular,
      color = DarkPaleBlue
    ),
    singleLine = true,
    colors = TextFieldDefaults.outlinedTextFieldColors(
      focusedBorderColor = DarkPaleBlue,
      unfocusedLabelColor = LightPaleBlue,
      focusedLabelColor = DarkPaleBlue,
      textColor = LightPaleBlue,
      unfocusedBorderColor = DarkPaleBlue
    ),
  )
}

@Preview
@Composable
fun PreviewInputField() {
  InputField("Hello", "hey"){}
}