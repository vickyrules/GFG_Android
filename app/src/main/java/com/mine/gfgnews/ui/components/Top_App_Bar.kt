package com.mine.gfgnews.ui.components

import android.graphics.drawable.Icon
import android.icu.text.CaseMap.Title
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.mine.gfgnews.ui.theme.Gfg

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Top_App_Bar(
    title: String = "",

) {
    TopAppBar(
        title = { Text(text = title) },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = Gfg
        )
    )
}