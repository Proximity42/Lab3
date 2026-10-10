package com.example.lab3

import android.R.attr.name
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab3.ui.theme.Lab3Theme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab3Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Seasons(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Seasons(modifier: Modifier = Modifier) {
    var input by remember {mutableStateOf("")}
    var result by remember {mutableStateOf("")}

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text="Определение сезона года",
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(32.dp))

        OutlinedTextField(
            value = input,
            onValueChange = {input = it},
            label = { Text("Введите номер сезона (1-4)")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                result = when(input.trim()) {
                    "1" -> "Зима"
                    "2" -> "Весна"
                    "3" -> "Лето"
                    "4" -> "Осень"
                    else -> "Ошибка. Введите число от 1 до 4"
                }
            },
            modifier = Modifier.height(32.dp)
        ) {
            Text("Определить сезон")
        }


    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    Lab3Theme {
        Seasons()
    }
}