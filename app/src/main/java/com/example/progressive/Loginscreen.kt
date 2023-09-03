package com.example.progressive

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.autofill.AutofillType
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.progressive.ui.theme.ProgressiveTheme
import org.w3c.dom.Text

class Loginscreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            LoginScreen()
        }
    }
}


@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Preview
@Composable

fun LoginScreen(){

    Column (
        horizontalAlignment=Alignment.CenterHorizontally,
        verticalArrangement=Arrangement.Center

                ,
        modifier = Modifier
            .background(Color.Cyan)
            .fillMaxSize()

    ){


        var username by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }



        OutlinedTextField(
            value = username,
            onValueChange = {
                            username = it
            },
            label = { Text(text = "User Name")},
            leadingIcon = {Icon(imageVector = Icons.Default.AccountBox, contentDescription = "")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),

        )



        Spacer(modifier = Modifier.height(10.dp))


        OutlinedTextField(
            value = password,
            label = { Text(text = "Password")},
            leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            onValueChange = {
                password = it
            })

        Spacer(modifier = Modifier.height(10.dp))


        val homepage = LocalContext.current
        TextButton(onClick = {

            homepage.startActivity(Intent(homepage,Homepage::class.java))

        },
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(Color.Magenta)
        )
        {

            Text(text = "Log In" )

        }

        Spacer(modifier = Modifier.height(10.dp))



        val products = LocalContext.current
        TextButton(onClick = {
            products.startActivity(Intent(products,Products::class.java))
                             },
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(Color.Magenta)
        )
        {

            Text(text = " Browse Products" )

        }







    }
}


