package com.example.shopappcomposefinal.presentation

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shopappcomposefinal.R
import com.example.shopappcomposefinal.presentation.viewmodels.RegistrationScreenViewModel
import com.example.shopappcomposefinal.tools.CustomButton
import com.example.shopappcomposefinal.tools.CustomOutlineTextField


@Composable
fun RegistrationScreen(registrationScreenViewModel: RegistrationScreenViewModel) {

    val screenState = registrationScreenViewModel.registrationScreenState

    val context = LocalContext.current


    Column(
        modifier = Modifier.fillMaxSize(1f),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(109.dp))

        Text(
            text = "Registration",
            fontSize = 26.sp,
            fontFamily = FontFamily(Font(R.font.montserrat_semibold)),
            color = colorResource(R.color.signInColor)
        )
        Spacer(modifier = Modifier.height(72.dp))


        CustomOutlineTextField(
            value = screenState.email,
            onValueChange = { inputText ->
                registrationScreenViewModel.changeRegistrationScreenState(screenState.copy(email = inputText))
            },
            text = "Email"
        )

        Spacer(modifier = Modifier.height(42.dp))

        CustomOutlineTextField(
            value = screenState.name,
            onValueChange = { inputText ->
                registrationScreenViewModel.changeRegistrationScreenState(screenState.copy(name = inputText))
            },
            text = "Your name"
        )

        Spacer(modifier = Modifier.height(42.dp))

        CustomOutlineTextField(
            value = screenState.password,
            onValueChange = { inputText ->
               registrationScreenViewModel.changeRegistrationScreenState(screenState.copy(password = inputText))
            },
            text = "Password",
            visualTransformation = if (screenState.visibilityPassword)
                VisualTransformation.None else PasswordVisualTransformation(),
            leadingIcon = {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.spacer),
                    contentDescription = ""
                )
            },
            trailingIcon = {
                val image = if (screenState.visibilityPassword)
                    Icons.Filled.Visibility
                else Icons.Filled.VisibilityOff

                val description =
                    if (screenState.visibilityPassword) "Hide password" else "Show password"

                IconButton(onClick = {
                    registrationScreenViewModel.changeRegistrationScreenState(
                        screenState.copy(
                            visibilityPassword =
                            !registrationScreenViewModel.registrationScreenState.visibilityPassword
                        )
                    )
                }) {
                    Icon(imageVector = image, description)
                }
            }

        )

        Spacer(modifier = Modifier.height(42.dp))

        CustomOutlineTextField(
            value = screenState.confirmPassword,
            onValueChange = { inputText ->
                registrationScreenViewModel.changeRegistrationScreenState(screenState.copy(confirmPassword = inputText))
            },
            text = "Сonfirm the password",
            visualTransformation = if (screenState.visibilityPassword)
                VisualTransformation.None else PasswordVisualTransformation(),
            leadingIcon = {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.spacer),
                    contentDescription = ""
                )
            },
            trailingIcon = {
                val image = if (screenState.visibilityPassword)
                    Icons.Filled.Visibility
                else Icons.Filled.VisibilityOff

                val description =
                    if (screenState.visibilityPassword) "Hide password" else "Show password"

                IconButton(onClick = {
                    registrationScreenViewModel.changeRegistrationScreenState(
                        screenState.copy(
                            visibilityPassword =
                            !registrationScreenViewModel.registrationScreenState.visibilityPassword
                        )
                    )
                }) {
                    Icon(imageVector = image, description)
                }
            }

        )

        Spacer(modifier = Modifier.height(106.dp))

        CustomButton(text = "Login"){
            registrationScreenViewModel.apply {
                checkPassword(){
                    Toast.makeText(
                        context, "Password and Confirm Password do not match",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                checkEmptyFields(){
                    Toast.makeText(
                        context,
                        "Email and Password can't be blank",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                signInToFireBase()
                registrationAndToEnterFB()
            }


        }
    }

}