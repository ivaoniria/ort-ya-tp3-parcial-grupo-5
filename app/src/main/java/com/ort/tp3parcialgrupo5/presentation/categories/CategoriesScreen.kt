package com.ort.tp3parcialgrupo5.presentation.categories

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ort.tp3parcialgrupo5.R
import com.ort.tp3parcialgrupo5.presentation.categories.components.CategoriesGrid
import com.ort.tp3parcialgrupo5.presentation.categories.model.Category
import com.ort.tp3parcialgrupo5.presentation.components.AccountBalanceSection
import com.ort.tp3parcialgrupo5.presentation.components.Header
import com.ort.tp3parcialgrupo5.presentation.components.PercentExpensesSection
import com.ort.tp3parcialgrupo5.ui.theme.TealDark
import com.ort.tp3parcialgrupo5.ui.theme.homeGradient

@Composable
fun CategoriesScreen(
    onBack: (() -> Unit)? = null,
    onBell: (() -> Unit)? = null,
    onCategoryClick: (Category) -> Unit = {}
) {
    val defaultCategoryColor = Color(0xFF6DB6FE)
    val specialCategoryColor = Color(0xFF5BA3D0)

    val categories = listOf(
        Category(R.drawable.vector_food, R.string.category_food, isSpecialColor = true),
        Category(R.drawable.vector_111, R.string.category_transport),
        Category(R.drawable.vector_pills, R.string.category_medicine),
        Category(R.drawable.vector_groceries, R.string.category_groceries),
        Category(R.drawable.group_2, R.string.category_rent),
        Category(R.drawable.vector_gifts, R.string.category_gifts),
        Category(R.drawable.vector_money, R.string.category_savings),
        Category(R.drawable.vector_tickets, R.string.category_entertainment),
        Category(R.drawable.group_390, R.string.category_more)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(homeGradient())
            .verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = Modifier.padding(
                start = 16.dp,
                end = 16.dp,
                top = 16.dp
            )
        ) {
            Header(
                title = stringResource(R.string.categories_title),
                onBack = onBack,
                onBell = onBell
            )
            Spacer(Modifier.height(12.dp))
            AccountBalanceSection()
            Spacer(Modifier.height(18.dp))
            PercentExpensesSection()
            Spacer(Modifier.height(18.dp))

        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp))
                .background(TealDark)
                .padding(top = 32.dp, start = 16.dp, end = 16.dp, bottom = 100.dp)
        ) {
            CategoriesGrid(
                categories = categories,
                defaultColor = defaultCategoryColor,
                specialColor = specialCategoryColor,
                onCategoryClick = onCategoryClick
            )
        }
    }
}

