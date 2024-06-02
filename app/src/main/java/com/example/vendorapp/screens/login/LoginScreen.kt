package com.example.vendorapp.screens.login

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.IconButton
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.vendorapp.R
import com.example.vendorapp.navigation.AppRoutes
import com.example.vendorapp.screens.common.CustomError
import com.example.vendorapp.screens.common.CustomLoading
import com.example.vendorapp.screens.signup.MedicalStoreButton
import com.example.vendorapp.viewmodel.LoginResult
import com.example.vendorapp.viewmodel.LoginViewModel
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(navHostController: NavHostController) {

    var passwordVisibility by remember { mutableStateOf(false) }

    val icon = if (passwordVisibility)
        painterResource(id = R.drawable.view)
    else
        painterResource(id = R.drawable.eye)

    val loginViewModel: LoginViewModel = hiltViewModel()
    val loginResult by loginViewModel.loginResult.collectAsState()

    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 24.dp)
            .wrapContentHeight()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Logo Image
        Image(
            painter = painterResource(id = R.drawable.drug),
            contentDescription = "Logo",
            modifier = Modifier
                .padding(bottom = 30.dp)
                .size(120.dp)
        )

        // Heading
        Text(
            text = "Login to Your Account",
            fontSize = 30.sp,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 16.dp),
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily(Font(R.font.sfpro)),
        )

        // Email input field
        OutlinedTextField(
            value = loginViewModel.userEmail,
            onValueChange = { loginViewModel.userEmail = it },
            leadingIcon = { Icon(Icons.Default.Email, contentDescription = "email") },
            label = { Text(text = "Email") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 0.dp, 0.dp, 16.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        // Password input field
        OutlinedTextField(
            value = loginViewModel.password,
            onValueChange = {
                loginViewModel.password = it
            },
            label = { Text(text = "Password") },
            leadingIcon = { Icon(Icons.Default.Lock, contentDescription = "person") },
            trailingIcon = {
                IconButton(onClick = {
                    passwordVisibility = !passwordVisibility
                }) {
                    Icon(
                        painter = icon,
                        contentDescription = "Visibility Icon",
                        modifier = Modifier
                            .size(32.dp)
                            .padding(end = 4.dp)
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            visualTransformation = if (passwordVisibility) VisualTransformation.None
            else PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 0.dp, 0.dp, 16.dp)
        )

        MedicalStoreButton(
            text = "Login",
            onClick = {
                if (loginViewModel.userEmail.isNotBlank() && loginViewModel.password.isNotBlank()) {
                    loginViewModel.loginUser(
                        email = loginViewModel.userEmail,
                        password = loginViewModel.password
                    )
                } else {
                    // Show a toast message indicating that all fields are required
                    coroutineScope.launch {
                        Toast.makeText(
                            context,
                            "Please fill in all the fields",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            },
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top = 20.dp)
        ) {
            Text(
                text = "Don't have an account? ",
                color = Color.Gray,
            )

            Text(
                text = "Sign up",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .clickable { navHostController.navigate(AppRoutes.SignupScreen) }
            )
        }
    }


    when (loginResult) {
        is LoginResult.Loading -> {
            CustomLoading()
        }
        is LoginResult.Error -> {
            CustomError(message = (loginResult as LoginResult.Error).message)
        }
        is LoginResult.Success -> {
            LaunchedEffect(Unit) {
                navHostController.navigate(AppRoutes.HomeScreen(loginViewModel.userEmail)) {
                    popUpTo(AppRoutes.SignInScreen) { inclusive = true }
                }
            }
        }
        is LoginResult.Idle -> {
            // Do nothing
        }

        else -> {}
    }

//    loginResult?.let { result ->
//        when (result) {
//            is LoginResult.Success -> {
//                navHostController.navigate(AppRoutes.HomeScreen(loginViewModel.userEmail))
//            }
//
//            is LoginResult.Error -> {
//                Text(text = result.message, color = Color.Red)
//            }
//
//            else -> {}
//        }
//    }
}


