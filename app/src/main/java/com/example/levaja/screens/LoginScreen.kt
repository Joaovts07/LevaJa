package com.example.levaja.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import com.example.levaja.ui.components.LevajaButton

@Composable
fun LoginScreen() {
    var name by remember { mutableStateOf("João Programador") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Logo Leva Já",
            modifier = Modifier.size(120.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
                .padding(16.dp), // Adiciona um padding geral ao Box
        ) {
            Column(
                modifier = Modifier
                    .width(300.dp)
                    .align(Alignment.Center)
            ) {
                Text(text = "Login", fontSize = 28.sp)
                Text(text = "Entre para continuar", color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f))
                Spacer(modifier = Modifier.height(10.dp))
                LevaJaTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = "NOME",
                    leadingIcon = { Icon(Icons.Filled.Person, contentDescription = "Ícone de Nome") },
                    placeholder = "NAME"

                )

                LevaJaTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = "SENHA",
                    leadingIcon = { Icon(Icons.Filled.Lock, contentDescription = "Ícone de Senha") },
                    placeholder = "SENHA",
                    visualTransformation = PasswordVisualTransformation()

                )

                LevajaButton("Entrar") { }
                Spacer(modifier = Modifier.height(10.dp))

                TextButton(
                    modifier = Modifier.align(Alignment.CenterHorizontally).padding(vertical = 2.dp),
                    onClick = {
                    println("Esqueceu a senha? clicado")
                }) {
                    Text("Esqueceu a senha?")
                }
                TextButton(
                    modifier = Modifier.align(Alignment.CenterHorizontally).padding(vertical = 2.dp),
                    onClick = {
                    println("criar conta clicado")
                }) {
                    Text("criar conta")
                }
            }


        }



    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen() {
    LoginScreen()
}