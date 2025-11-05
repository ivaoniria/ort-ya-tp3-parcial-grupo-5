package com.ort.tp3parcialgrupo5.presentation.categories.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ort.tp3parcialgrupo5.presentation.categories.model.Category

@Composable
fun CategoriesGrid(
    categories: List<Category>,
    defaultColor: Color,
    specialColor: Color,
    onCategoryClick: (Category) -> Unit,
    modifier: Modifier = Modifier
) {
    var selectedIndex by rememberSaveable { mutableStateOf(-1) }

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        categories.chunked(3).forEachIndexed { rowIndex, rowCategories ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                rowCategories.forEachIndexed { colIndex, category ->
                    val index = rowIndex * 3 + colIndex
                    val bg = if (selectedIndex == index) specialColor else defaultColor

                    Box(
                        modifier = Modifier.weight(1f),
                        contentAlignment = Alignment.Center
                    ) {
                        CategoryButton(
                            iconRes = category.iconRes,
                            nameRes = category.nameRes,
                            backgroundColor = bg,
                            onClick = {
                                if (category.nameRes != com.ort.tp3parcialgrupo5.R.string.category_more) {
                                    selectedIndex = index
                                }
                                onCategoryClick(category)
                            }
                        )
                    }
                }
                repeat(3 - rowCategories.size) {
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}
