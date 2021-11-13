package com.aditya.composecollapsingtoolbar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.aditya.composecollapsingtoolbar.ui.theme.ComposeCollapsingToolbarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCollapsingToolbarTheme {
                MainScreen()
            }
        }
    }
}
