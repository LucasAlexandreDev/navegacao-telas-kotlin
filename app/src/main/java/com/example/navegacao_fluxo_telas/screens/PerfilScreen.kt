package com.example.navegacao_fluxo_telas.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun TelaPerfil(
    modifier: Modifier = Modifier,
    navController: NavController,
    nomeUsuario: String,
    idade: Int
    ){

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF329F6B))

    ) {

        Text(
            text = "PERFIL - ${nomeUsuario} - $idade",
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Button(
            modifier = modifier.align(Alignment.Center),

            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White
            ),

            onClick = { navController.navigate("menu")},
            shape = RoundedCornerShape(16.dp),

            )

        {
            Text(
                text = "VOLTAR",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Blue
            )
        }
    }
}