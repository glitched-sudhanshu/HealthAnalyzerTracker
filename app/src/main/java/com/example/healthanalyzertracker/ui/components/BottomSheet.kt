package com.example.healthanalyzertracker.ui.components

import android.widget.NumberPicker
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(
  onDismiss: () -> Unit,
  minNumValue: Int = 10,
  maxNumValue: Int = 110,
  onNumChange: (String) -> Unit
) {
  val sheetState = rememberModalBottomSheetState()
  ModalBottomSheet(
    onDismissRequest = { onDismiss() },
    sheetState = sheetState,
    dragHandle = { BottomSheetDefaults.DragHandle() },
  ) {
    AndroidView(
      modifier = Modifier.fillMaxWidth(),
      factory = { context ->
        NumberPicker(context).apply {
          setOnValueChangedListener { _, _, newVal ->
            onNumChange(newVal.toString())
          }
          minValue = minNumValue
          maxValue = maxNumValue
        }
      }
    )
  }
}
