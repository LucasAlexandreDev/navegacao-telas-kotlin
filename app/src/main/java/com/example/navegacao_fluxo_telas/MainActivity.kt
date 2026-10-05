package com.example.navegacao_fluxo_telas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navegacao_fluxo_telas.screens.TelaLogin
import com.example.navegacao_fluxo_telas.screens.TelaMenu
import com.example.navegacao_fluxo_telas.screens.TelaPedido
import com.example.navegacao_fluxo_telas.screens.TelaPerfil
import com.example.navegacao_fluxo_telas.ui.theme.NavegacaofluxotelasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavegacaofluxotelasTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    val navController = rememberNavController()

                    NavHost(

                        navController    = navController,
                        startDestination = "login"
                    ){

                        composable(route = "login") {
                            TelaLogin(modifier = Modifier.padding(innerPadding))
                        }

                        composable(route = "menu") {
                            TelaMenu(modifier = Modifier.padding(innerPadding))
                        }

                        composable(route = "pedidos") {
                            TelaPedido(modifier = Modifier.padding(innerPadding))
                        }

                        composable(route = "perfil") {
                            TelaPerfil(modifier = Modifier.padding(innerPadding))
                        }
                    }
                }
            }
        }
    }
}
