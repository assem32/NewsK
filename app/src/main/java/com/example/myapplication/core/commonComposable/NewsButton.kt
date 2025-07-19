package com.example.myapplication.core.commonComposable

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.feature.boardingScreen.domain.entity.pages
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun NewsButton(
    text: String,

    color: Color = MaterialTheme.colorScheme.primary,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = color,
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(text = text, style = TextStyle(fontWeight = FontWeight.SemiBold, fontSize = 10.sp))
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonView() {
    MyApplicationTheme {
        NewsButton(text = "Next", onClick = {})
    }

}