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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun FirstScreen(
    navigationToSecondScreen:(Int,String)->Unit)
{
    val name = remember{ mutableStateOf("") }
    var age by remember{ mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "This is the First Screen", fontSize = 24.sp)
        Spacer(modifier = Modifier.padding(16.dp))
        OutlinedTextField(value = name.value,
            onValueChange ={
                name.value = it
            } )
        OutlinedTextField(value = age.toString(),
            onValueChange ={
                age = it.toInt()
            } )
        Button(onClick = {
            navigationToSecondScreen(age,name.value)
        }) {
            Text(text = "Go to Second Screen")

        }
    }
}
