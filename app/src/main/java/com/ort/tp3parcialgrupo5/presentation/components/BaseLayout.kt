package com.ort.tp3parcialgrupo5.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.ort.tp3parcialgrupo5.ui.theme.BackgroundListContainer
import com.ort.tp3parcialgrupo5.ui.theme.BackgroundMainContainer

@Composable
fun BaseLayout(
    modifier: Modifier = Modifier,
    backgroundMainColor: Color = BackgroundMainContainer,
    backgroundListColor: Color = BackgroundListContainer,
    listContainerModifier: Modifier = Modifier.fillMaxSize(),
    contentTop: @Composable () -> Unit = {},
    contentBottom: LazyListScope.() -> Unit
) {
    Scaffold(containerColor = Color.Transparent) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(backgroundMainColor)
                .padding(top = innerPadding.calculateTopPadding())
        ) {
            Column(
                modifier = listContainerModifier.then(modifier),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Box(modifier = Modifier.padding(horizontal = 24.dp)) {
                    Column { contentTop() }
                }


                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp)
                        .clip(RoundedCornerShape(topStart = 60.dp, topEnd = 60.dp))
                        .background(backgroundListColor)
                ) {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 24.dp, horizontal = 24.dp),
                        contentPadding = PaddingValues(bottom = 16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        content = contentBottom
                    )
                }
            }
        }
    }
}
