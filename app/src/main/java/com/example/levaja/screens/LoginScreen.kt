package com.example.levaja.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.levaja.R
import com.example.levaja.ui.components.LevaJaTextField

@Composable
fun LoginScreen() {
    var name by remember { mutableStateOf("João Programador") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Logo Leva Já",
            modifier = Modifier.size(120.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Login", fontSize = 28.sp)
        Text(text = "Entre para continuar", color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f))
        Spacer(modifier = Modifier.height(10.dp))
        var nome by remember { mutableStateOf("") }
        LevaJaTextField(
            value = nome,
            onValueChange = { nome = it },
            label = "NOME",
            leadingIcon = { Icon(Icons.Filled.Person, contentDescription = "Ícone de Nome") },
            placeholder = "NAME"

        )

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("SENHA") },
            leadingIcon = { Icon(Icons.Filled.Lock, contentDescription = "Ícone de Senha") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                println("Botão Entrar clicado com Nome: $name, Senha: $password")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Entrar")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TextButton(onClick = {
                println("Esqueceu a senha? clicado")
            }) {
                Text("Esqueceu a senha?")
            }
            TextButton(onClick = {
                println("criar conta clicado")
            }) {
                Text("criar conta")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen() {
    LoginScreen()
}