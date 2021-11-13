package com.aditya.composecollapsingtoolbar.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.aditya.composecollapsingtoolbar.R
import kotlin.math.roundToInt

@Composable
fun MainScreenTopBar(
    topbarHeight: Dp,
    topbarOffsetHeightAnim: Float
) {
    TopAppBar(
        modifier = Modifier
            .height(topbarHeight)
            .offset { IntOffset(x = 0, y = topbarOffsetHeightAnim.roundToInt()) },
        elevation = 0.dp,
        title = { Text(text = stringResource(id = R.string.app_name), color = Color.White) },
        backgroundColor = Color.Blue
    )
}
