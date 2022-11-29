package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //conteudo que sera mostardo ao rodar
        setContent {
            MessageCard(Message("Andrey o Tal", "Rei do kotlin não tem jeito"))
        }
    }
}

data class Message(val author: String, val body: String)

@Composable

//função que renderiza o card de menssagem
fun MessageCard(msg: Message) {
    //Alinha todos os elementos de dentro em linha
    Row(
        //Cria espaço de todos os lados do card
        modifier = Modifier.padding(all = 8.dp)
    ) {

        //icone do do usuário
        Image(
            //seleciona a imagem que sera usada
            painter = painterResource(R.drawable.senhor),
            //texto para caso imagem não carrege
            contentDescription = "Icone do usuário",
            //Define estilo do imagem
            modifier = Modifier
                .size(45.dp)
                .clip(CircleShape)
        )

        //Separa os elementos horizontalmente
        Spacer(modifier = Modifier
            .width(8.dp))

        //alinha elementos de dentro em coluna
        Column {
            //texto com nome do usuário
            Text(text = msg.author)

            //Separa os elementos verticalmente
            Spacer(modifier = Modifier
                .height(4.dp))

            //texto de descrição
            Text(text = msg.body)
        }
    }

}

@Preview
@Composable
//preview para testes
fun PreviewMessageCard() {
    val name = "preview"
    MessageCard(Message("Andrey o Tal", "Rei do kotlin não tem jeito"))
}