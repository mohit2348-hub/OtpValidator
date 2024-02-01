package com.example.otpvalidator

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.otpvalidator.ui.theme.OtpValidatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OtpValidatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    Box (modifier= Modifier
        .fillMaxSize()
        .background(color = colorResource(id = R.color.teal_200)), contentAlignment = Alignment.Center){
        Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            OtpComposableOutlined(
                heightInDp = 55.dp,
                widthInDp = 55.dp,
                cornerRadius = 8.dp ,
                focusColor =  Color.Black,
                unfocusColor = Color.LightGray,
                passwordToggle = false,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(2.dp),
                backgroundColor = Color.White,
                onvaluechange = {
                    Log.d("LogTagOnValueChnage", it)
                })
        }

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    OtpValidatorTheme {
        Greeting()
    }
}