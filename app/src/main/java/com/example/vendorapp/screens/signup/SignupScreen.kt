package com.example.vendorapp.screens.signup

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
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.IconButton
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.vendorapp.R
import com.example.vendorapp.navigation.AppRoutes
import com.example.vendorapp.viewmodel.CreateUserResult
import com.example.vendorapp.viewmodel.UserViewModel


@Composable
fun SignupScreen(navHostController: NavHostController) {


    var passwordVisibility by remember { mutableStateOf(false) }

    val icon = if (passwordVisibility)
        painterResource(id = R.drawable.view)
    else
        painterResource(id = R.drawable.eye)

    val userViewModel: UserViewModel = hiltViewModel()
    val createUserResult by userViewModel.createUserResult.collectAsState()






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
            painter = painterResource(id = R.drawable.drug), // Replace R.drawable.logo with your actual logo resource ID
            contentDescription = "Logo",
            modifier = Modifier
                .padding(bottom = 30.dp)
                .size(120.dp)
        )

        // Heading

        Text(
            text = "Create an Account",
            fontSize = 30.sp,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 16.dp),
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily(Font(R.font.sfpro)),
        )

//        Text(
//            text = "Sign Up",
//            fontSize = 30.sp,
//            color = Color.Black,
//            textAlign = TextAlign.Center,
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(bottom = 30.dp)
//        )


        // Username input field
        OutlinedTextField(
            value = userViewModel.userName,
            onValueChange = { userViewModel.userName = it },
            leadingIcon = { Icon(Icons.Default.Person, contentDescription = "person") },
            label = { Text(text = "Username") },
            textStyle = TextStyle(
                fontFamily = FontFamily(Font(R.font.sfpro))
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 0.dp, 0.dp, 16.dp),
        )

        // Email input field
        OutlinedTextField(
            value = userViewModel.userEmail,
            onValueChange = { userViewModel.userEmail = it },
            leadingIcon = { Icon(Icons.Default.Email, contentDescription = "email") },
            label = { Text(text = "Email") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 0.dp, 0.dp, 16.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        // Password input field
        OutlinedTextField(
            value = userViewModel.password,
            onValueChange = {
                userViewModel.password = it
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


        // Phone input field
        OutlinedTextField(
            value = userViewModel.userPhone,
            onValueChange = { userViewModel.userPhone = it },
            leadingIcon = { Icon(Icons.Default.Phone, contentDescription = "phone") },
            label = { Text(text = "Phone") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 0.dp, 0.dp, 16.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
        )

        // Address input field
        OutlinedTextField(
            value = userViewModel.userAddress,
            onValueChange = { userViewModel.userAddress = it },
            leadingIcon = { Icon(Icons.Default.Home, contentDescription = "address") },
            label = { Text(text = "Address") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 0.dp, 0.dp, 16.dp)
        )

        // Pincode input field
        OutlinedTextField(
            value = userViewModel.userPincode,
            onValueChange = { userViewModel.userPincode = it },
            leadingIcon = { Icon(Icons.Default.LocationOn, contentDescription = "pincode") },
            label = { Text(text = "Pincode") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 0.dp, 0.dp, 16.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        MedicalStoreSignupButton(
            onClick = {
                userViewModel.createUser(
                    password = userViewModel.password,
                    userName = userViewModel.userName,
                    userAddress = userViewModel.userAddress,
                    userEmail = userViewModel.userEmail,
                    userPhone = userViewModel.userPhone,
                    userPincode = userViewModel.userPincode
                )
            },
        )

//        Text(
//            text = "Already have an account? Sign in",
//            color = Color.Gray,
//            modifier = Modifier
//                .padding(top = 20.dp)
//                .clickable {  }
//        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top = 20.dp)
        ) {
            Text(
                text = "Already have an account? ",
                color = Color.Gray,
            )

            Text(
                text = "Sign in",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .clickable { /* Handle Sign in click */ }
            )
        }

    }


    createUserResult?.let { result ->
        when (result) {
            is CreateUserResult.Success -> {
                // Handle success
               // Text(text = result.message, color = Color.Green)
                navHostController.navigate(AppRoutes.HomeScreen(userViewModel.userName))

            }

            is CreateUserResult.Error -> {
                // Handle error
                Text(text = result.message, color = Color.Red)
            }
        }
    }

}






