package com.example.levaja.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun LevaJaTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    leadingIcon: @Composable (() -> Unit)? = null,
    placeholder: String? = null // Adicionamos o parâmetro placeholder
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        leadingIcon = leadingIcon,
        placeholder = { // Usamos o parâmetro placeholder aqui
            if (placeholder != null) {
                Text(placeholder)
            }
        },
        modifier = Modifier
            .padding(16.dp)
            .background(
                color = Color.LightGray.copy(alpha = 0.3f),
                shape = RoundedCornerShape(8.dp)
            ),
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            cursorColor = Color.Black
        ),
        shape = RoundedCornerShape(8.dp)
    )
}
