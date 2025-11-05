package com.ort.tp3parcialgrupo5.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.ort.tp3parcialgrupo5.navigation.Route
import com.ort.tp3parcialgrupo5.ui.theme.BackgroundBottomNav
import com.ort.tp3parcialgrupo5.ui.theme.BackgroundListContainer
import com.ort.tp3parcialgrupo5.ui.theme.FinBrand

data class BottomNavItem(
    val label: String,
    val icon: Int,
    val route: Route
)

@Composable
fun BottomNavigationBar(
    modifier: Modifier = Modifier,
    selectedRoute: String?,
    onItemSelected: (Route) -> Unit,
    items: List<BottomNavItem>,
    selectedColor: Color = FinBrand,
    backgroundColor: Color = BackgroundBottomNav,
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(108.dp),
        color = BackgroundListContainer
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(topStart = 70.dp, topEnd = 70.dp, bottomStart = 40.dp, bottomEnd = 40.dp))
                .background(backgroundColor.copy(alpha = 0.95f))
                .padding(horizontal = 24.dp, vertical = 12.dp),
            contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                items.forEach { item ->
                    val isSelected = item.route::class.qualifiedName == selectedRoute
                    val iconColor = Color.White
                    val bgColor = if (isSelected) selectedColor else Color.Transparent

                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(18.dp))
                            .size(if (isSelected) 44.dp else 40.dp)
                            .background(bgColor)
                            .padding(vertical = 8.dp)
                            .clickable { onItemSelected(item.route) },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(item.icon),
                            contentDescription = item.label,
                            tint = iconColor
                        )
                    }
                }
            }
        }
    }
}
