package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var list: ArrayList<Message> = ArrayList()

        setContent {

            list.add(Message("hi", "hello"))
            list.add(Message("hi", "hello"))
            list.add(Message("hi", "hello"))
            list.add(Message("hi", "hello"))
            list.add(Message("hi", "hello"))
            list.add(Message("hi", "hello"))
            list.add(Message("hi", "hello"))
            list.add(Message("hi", "hello"))
            list.add(Message("hi", "hello"))
            list.add(Message("hi", "hello"))
            list.add(Message("hi", "hello"))
            list.add(Message("hi", "hello"))
            list.add(Message("hi", "hello"))

            ListOfMessageCard(list)
        }
    }
}

data class Message(val author: String, val body: String)

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
    Text(text = "Hello $name!")
}

@Composable
fun MessageCard(msg: Message) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .border(2.dp, color = Color.Red)
    ) {
        Image(
            painter = painterResource(R.drawable.ic_launcher_background),
            contentDescription = "Contact profile picture",
            modifier = Modifier
                .size(40.dp)
                .padding(10.dp)
                .align(Alignment.CenterVertically)
                .clip(CircleShape)
                .border(2.dp, color = Color.Black, shape = CircleShape)
        )
        Spacer(modifier = Modifier.height(5.dp))
        Column(
            modifier = Modifier
                .padding(10.dp)
                .background(color = Color.White)
                .fillMaxWidth(1.0f)
        ) {
            Text(
                text = msg.author,
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.subtitle2
            )
            Text(
                text = msg.body,
                style = MaterialTheme.typography.body2
            )
        }
    }

}

@Composable
fun ListOfMessageCard(messages: ArrayList<Message>) {
    LazyColumn(modifier = Modifier.padding(5.dp)) {
        items(messages) { message ->
            MessageCard(message)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        MessageCard(Message("hello", "world"))
    }
}
