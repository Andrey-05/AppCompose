package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //conteudo que sera mostardo ao rodar
        setContent {
            Text("Teste do Compose")
            MessageCard("Andrey o tal")
        }
    }
}

@Composable

//função que renderiza o card de menssagem
fun MessageCard(name: String) {
    Text(text = "Hello $name")
}

@Preview
@Composable
//preview para testes
fun PreviewMessageCard() {
    val name = "preview"
    Text(text = "Hello $name")
}