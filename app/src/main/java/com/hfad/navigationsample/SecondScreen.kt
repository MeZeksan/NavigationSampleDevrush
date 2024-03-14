package com.hfad.navigationsample

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun SecondScreen(
    age:Int,
    name:String,
    navigationToThirdScreen: (String) -> Unit
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "This is the Second Screen", fontSize = 24.sp)
        Text(text = "Welcome $name", fontSize = 24.sp)
        Text(text = "Your age $age", fontSize = 24.sp)
        Spacer(modifier = Modifier.padding(16.dp))

            Button(onClick = {
                navigationToThirdScreen(name)
            }) {
                Text(text = "Go to Third Screen")
            }
        }
    }


@Preview(showBackground = true)
@Composable
fun SecondScreenPreview(){
    SecondScreen(2,"И",{})
}