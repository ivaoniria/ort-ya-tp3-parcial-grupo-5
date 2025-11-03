package com.ort.tp3parcialgrupo5.presentation.categories.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
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
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        categories.chunked(3).forEach { rowCategories ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                rowCategories.forEach { category ->
                    CategoryButton(
                        iconRes = category.iconRes,
                        nameRes = category.nameRes,
                        backgroundColor = if (category.isSpecialColor) specialColor else defaultColor,
                        onClick = { onCategoryClick(category) }
                    )
                }
                repeat(3 - rowCategories.size) {
                    Spacer(modifier = Modifier.width(90.dp))
                }
            }
        }
    }
}

