package com.example.healthanalyzertracker.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDownCircle
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import com.example.healthanalyzertracker.ui.theme.BackgroundGrey
import com.example.healthanalyzertracker.ui.theme.LightPaleBlue
import com.example.healthanalyzertracker.ui.theme.PlaypenSans

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CustomDropDownMenu(
  suggestions: List<String>,
  selectedText: String,
  labelText : String,
  modifier: Modifier = Modifier,
  onOptionSelect: (String) -> Unit,
) {
  var expanded by remember { mutableStateOf(false) }
  var textFieldSize by remember { mutableStateOf(Size.Zero) }
  val icon = if (expanded)
    Icons.Filled.KeyboardArrowUp
  else
    Icons.Filled.KeyboardArrowDown


  ExposedDropdownMenuBox(
    expanded = expanded,
    onExpandedChange = { expanded = it },
    modifier = modifier.fillMaxWidth()
  ) {
    OutlinedTextField(
      value = selectedText,
      onValueChange = { onOptionSelect(it) },
      readOnly = true,
      modifier = Modifier
        .fillMaxWidth()
        .onGloballyPositioned { coordinates ->
          textFieldSize = coordinates.size.toSize()
        },
      label = { Text(labelText) },
      trailingIcon = {
        Icon(icon, "contentDescription",
          Modifier.clickable { expanded = !expanded })
      }
    )
    DropdownMenu(
      expanded = expanded,
      onDismissRequest = { expanded = false },
      modifier = Modifier
        .width(with(LocalDensity.current) { textFieldSize.width.toDp() })
    ) {
      suggestions.forEach { label ->
        DropdownMenuItem(onClick = {
          onOptionSelect(label)
          expanded = false
        }) {
          Text(text = label)
        }
      }
    }
  }

}

@Composable
fun BottomSheetDropDown(text: String, modifier: Modifier = Modifier, onActionClick: () -> Unit) {
  Row(
    modifier = modifier
      .background(color = LightPaleBlue, shape = RoundedCornerShape(15.dp))
      .clickable(
        onClick = { onActionClick() },
        interactionSource = remember { MutableInteractionSource() },
        indication = rememberRipple(bounded = true)
      )
      .padding(vertical = 10.dp, horizontal = 10.dp),
    horizontalArrangement = Arrangement.SpaceBetween
  ) {
    Text(text = text, fontFamily = PlaypenSans.regular, color = BackgroundGrey)
    Icon(
      imageVector = Icons.Filled.ArrowDropDownCircle,
      contentDescription = null,
      tint = Color.White,
      modifier = Modifier.padding(start = 15.dp)
    )
  }
}