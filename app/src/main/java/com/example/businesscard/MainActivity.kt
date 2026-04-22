package com.example.businesscard

import android.R.attr.name
import android.os.Bundle
import android.util.Log.v
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize(), containerColor = Color(0xFFD2E8D4)) { innerPadding ->
                    BusinessCard(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Logo(avatar : Painter, name: String, tilte: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
          ){
        Image(
            painter = avatar,
            contentDescription = null,
            modifier = Modifier.padding(bottom = 8.dp).size(150.dp).padding(bottom = 8.dp),
        )
        Text(
            text = name,
            modifier = Modifier.padding(bottom = 4.dp),
            fontSize = 24.sp,
        )
        Text(
            text = tilte,
            modifier = Modifier,
            color = Color(0xFF006D3B),
            fontWeight = FontWeight.Bold,
        )
    }
}

@Composable
fun Contact(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(bottom = 20.dp)) {
        val iconColor = Color(0xFF006D3B)
        ContactRow(painterResource(R.drawable.baseline_phone_24), "0859988968")
        ContactRow(painterResource(R.drawable.baseline_share_24), "@phamtuyen")
        ContactRow(painterResource(R.drawable.outline_attach_email_24), "phamvantuyen1110@gmail.com")
    }
}

@Composable
fun ContactRow(icon: Painter, text: String) {
    Row(
        modifier = Modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = icon,
            contentDescription = null,
            modifier = Modifier.size(28.dp)
        )
        Text(
            text = text,
            modifier = Modifier.padding(start = 16.dp),
            color = Color(0xFF006D3B)
        )
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Column(modifier = modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Logo(painterResource(R.drawable.unnamed), "Phạm Văn Tuyền", "Sinh viên khoa CNTT")
        }
        Contact()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}