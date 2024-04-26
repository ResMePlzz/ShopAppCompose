package com.example.shopappcomposefinal.presentation

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.shopappcomposefinal.R
import com.example.shopappcomposefinal.navigation.AllScreen
import com.example.shopappcomposefinal.presentation.viewmodels.GlobalViewModel
import com.example.shopappcomposefinal.presentation.viewmodels.SignInViewModel
import com.example.shopappcomposefinal.tools.CustomButton
import com.example.shopappcomposefinal.tools.CustomOutlineTextField
import kotlinx.coroutines.launch


@Composable
fun SignInScreen(
    signInViewModel: SignInViewModel, navigator: NavHostController,
    globalViewModel: GlobalViewModel
) {


    val screenState = signInViewModel.signInScreenState


    val firstNameTextState: MutableState<String> = remember {
        mutableStateOf("")
    }

    val coroutineScope = rememberCoroutineScope()

    val launcherActivityResult = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult(),
        onResult = {
            signInViewModel.resultGoogleAuth(it) {
                globalViewModel.providerAuth = "google"
                navigator.navigate(AllScreen.MainScreen.route)
            }


        })



    Column(
        modifier = Modifier.fillMaxSize(1f),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(107.dp))

        Text(
            text = "Sign In",
            fontSize = 26.sp,
            fontFamily = FontFamily(Font(R.font.montserrat_semibold)),
            color = colorResource(R.color.signInColor)
        )

        Spacer(modifier = Modifier.height(60.dp))

        CustomOutlineTextField(
            value = screenState.login,
            onValueChange = { inputText ->
                signInViewModel.changeSignInScreenState(screenState.copy(login = inputText))
            },
            text = "Email"
        )

        Spacer(modifier = Modifier.height(35.dp))

        CustomOutlineTextField(
            value = screenState.password,
            onValueChange = { inputText ->
                signInViewModel.changeSignInScreenState(screenState.copy(password = inputText))
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
                    signInViewModel.changeSignInScreenState(
                        screenState.copy(
                            visibilityPassword =
                            !signInViewModel.signInScreenState.visibilityPassword
                        )
                    )
                }) {
                    Icon(imageVector = image, description)
                }
            }
        )


        Spacer(modifier = Modifier.height(35.dp))

        CustomButton(text = "Sign in") {
//            signInViewModel.signInToFBWithPassword()
//            navigator.navigate(AllScreen.MainScreen.route)
        }

        Spacer(modifier = Modifier.height(15.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(16.dp)
                .padding(start = 42.dp), horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = "Don't you have an account?",
                fontStyle = FontStyle(R.color.annotationText),
                fontSize = 10.sp,
                textAlign = TextAlign.Start,
                fontFamily = FontFamily(Font(R.font.montserrat_medium500)),
                color = colorResource(R.color.annotationText)
            )

            Text(
                text = "  Registration",
                Modifier.clickable { navigator.navigate(AllScreen.RegistrationScreen.route) },
                fontStyle = FontStyle(R.color.annotationText2),
                fontSize = 10.sp,
                textAlign = TextAlign.Start,
                fontFamily = FontFamily(Font(R.font.montserrat_medium500)),
                color = colorResource(R.color.annotationText2)
            )
        }

        Spacer(modifier = Modifier.height(70.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(24.219.dp)
                .padding(start = 99.dp)
                .clickable {
                    coroutineScope.launch {
                        launcherActivityResult.launch(signInViewModel.googleSignInClient.signInIntent)

                    }
                }
        ) {
//
            Icon(
                painter = painterResource(R.drawable.google_image), contentDescription = "",
                modifier = Modifier
                    .width(23.828.dp)
                    .height(24.219.dp)

            )
            Text(
                text = "   Sign in with Google",
                modifier = Modifier.align(Alignment.Bottom),
                fontFamily = FontFamily(Font(R.font.montserrat_medium500)),
                fontSize = 12.sp,
            )


        }
        Spacer(modifier = Modifier.height(38.dp))


    }

}