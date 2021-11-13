package com.aditya.composecollapsingtoolbar.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp

@Composable
fun MainScreenList(
    topbarHeight: Dp
) {
    LazyColumn(contentPadding = PaddingValues(top = topbarHeight)) {
        items(100) { index ->
            MainScreenListItem(index)
        }
    }
}
