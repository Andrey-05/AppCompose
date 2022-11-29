package com.example.jetpackcompose

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.tutorial.SampleData
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme
import com.example.jetpackcompose.ui.theme.shapeScheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //conteudo que sera mostardo ao rodar
        setContent {
            JetpackComposeTheme {
                AllCard(SampleData.conversationSample)
            }
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
                .border(1.5.dp, MaterialTheme.colorScheme.tertiary, CircleShape)
        )

        //Separa os elementos horizontalmente
        Spacer(modifier = Modifier
            .width(8.dp))

        //criar um variavel para checar de a descrição esta ativa
        var isExpanded by remember {
            mutableStateOf(false)
        }

        //cria animação com a descrição
        val surfaceColor by animateColorAsState(
            if (isExpanded) MaterialTheme.colorScheme.tertiary else MaterialTheme.colorScheme.surface,
        )

        //alinha elementos de dentro em coluna
        Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
            //texto com nome do usuário
            Text(
                text = msg.author,
                //define estilo do texto
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleSmall
            )

            //Separa os elementos verticalmente
            Spacer(modifier = Modifier.height(4.dp))

            Surface(
                shape = MaterialTheme.shapeScheme.medium,
                tonalElevation = 1.dp,
                color = surfaceColor,
                modifier = Modifier.animateContentSize().padding(1.dp)
            ) {
                //texto de descrição
                Text(
                    // define o estilo da fonte do texto
                    text = msg.body,
                    //define margem para todos os lados
                    modifier = Modifier.padding(all = 4.dp),
                    //define maximo de linhas
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                    //define estilos
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Composable
fun AllCard(messages: List<Message>) {
    LazyColumn {
        messages.map {
            item {
                MessageCard(it)
            }
        }
    }
}


//versões dark mode e ligth mode
@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)

@Preview
@Composable
//preview para testes
fun PreviewMessageCard() {
    val name = "preview"
    JetpackComposeTheme {
        AllCard(SampleData.conversationSample)
    }
}