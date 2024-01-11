package com.example.finalprojectpam.ui.halamanutama

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
//import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.finalprojectpam.R
import com.example.finalprojectpam.navigasi.DestinasiNavigasi
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

object DestinasiHome : DestinasiNavigasi {
    override val route = "Cover"
    override val titleRes = "Cover"
}

//Test

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoverScreen(
    navController: NavController
) {
    val context = LocalContext.current
    lateinit var auth: FirebaseAuth
    auth = Firebase.auth
    var emailText by remember { mutableStateOf("") }
    var passwordText by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        // Background Image
        Image(
            painter = painterResource(id = R.drawable.bg_login),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(80.dp),
                    verticalArrangement = Arrangement.Top
                ) {
                    Text(
                        text = "Jikustik",
                        color = Color.DarkGray,
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 55.sp,
                        fontWeight = FontWeight.Bold,
                        modifier =  Modifier
                            .align(Alignment.CenterHorizontally)
                    )
                    Text(
                        text = "Aplication",
                        color = Color.DarkGray,
                        fontFamily = FontFamily.Serif,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    )

                }
            }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(horizontal = 35.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(value = emailText,
                onValueChange = { emailText = it },
                label = { Text(text = "Email")},
                singleLine = true,
                leadingIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Filled.Email,
                            contentDescription = "Email Icon")
                    }
                },
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier.padding(vertical = 5.dp)
            )
            OutlinedTextField(value = passwordText,
                onValueChange = {passwordText = it},
                label = { Text(text = "Password")},
                visualTransformation = PasswordVisualTransformation(),
                singleLine = true,
                leadingIcon = {
                    IconButton(onClick = { }) {
                        Icon(imageVector = Icons.Filled.Lock, contentDescription = "Pass Icon")
                    }
                },
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier.padding( vertical = 5.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { (
                        auth.signInWithEmailAndPassword(emailText, passwordText)
                            .addOnCompleteListener { task ->
                                if (task.isSuccessful) {
                                    navController.navigate(DestinasiMenu.route)
                                    Toast.makeText(context, "Login success", Toast.LENGTH_SHORT).show()
                                } else {
                                    Toast.makeText(context, "Login failed", Toast.LENGTH_SHORT).show()
                                }
                            }
                        ) },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    Color.DarkGray
                )
            )
            {
                Text(text = "Sign in")
            }
            Spacer(modifier = Modifier.height(16.dp))
        }}


