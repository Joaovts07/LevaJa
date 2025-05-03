package com.example.levaja.screens

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.levaja.R
import com.example.levaja.ui.components.LevaJaTextField
import com.example.levaja.ui.components.LevajaButton
import com.example.login2.presentation.login.LoginViewModel
import com.example.login2.presentation.login.launchGoogleSignIn
import com.example.login.ui.components.GoogleSignInButton

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel = hiltViewModel()
) {
    var name by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val context = LocalContext.current

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { result ->
        viewModel.handleGoogleSignInResult(result)
    }

    Column(
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = R.drawable.screenshot_from_2025_04_26_16_56_00),
            contentDescription = "Logo Leva Já",
            modifier = Modifier.size(300.dp).align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
                .padding(16.dp),
        ) {
            Column(
                modifier = Modifier
                    .width(300.dp)
                    .align(Alignment.Center)
            ) {
                Text(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally),
                    text = "Login", fontSize = 28.sp
                )
                Text(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally),
                    text = "Entre para continuar", color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f))
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

                GoogleSignInButton {
                    launchGoogleSignIn(context, launcher  )
                }

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