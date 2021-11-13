package com.aditya.composecollapsingtoolbar

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

@Composable
fun MainScreen() {

    val topbarHeight = 64.dp
    val topbarHeightPx = with(LocalDensity.current) { topbarHeight.roundToPx().toFloat() }
    var topbarOffsetState by remember { mutableStateOf(0f) }
    val topbarOffsetHeightAnim by animateFloatAsState(
        targetValue = topbarOffsetState,
        animationSpec = tween(
            durationMillis = 150,
            easing = LinearOutSlowInEasing
        )
    )

    val nestedScrollConnection = remember {
        object : NestedScrollConnection {
            override fun onPreScroll(
                available: Offset,
                source: NestedScrollSource
            ): Offset {
                val change = available.y
                val changedOffset = topbarOffsetState + change
                topbarOffsetState = changedOffset.coerceIn(-topbarHeightPx, 0f)
                return Offset.Zero
            }
        }
    }

    Box(modifier = Modifier.fillMaxSize().nestedScroll(nestedScrollConnection)) {
    }

    TopAppBar(
        modifier = Modifier
            .height(topbarHeight)
            .offset { IntOffset(x = 0, y = topbarOffsetHeightAnim.roundToInt()) },
        elevation = 0.dp
    ) {}
}
