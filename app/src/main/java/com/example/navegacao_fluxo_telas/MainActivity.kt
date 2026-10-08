package com.example.navegacao_fluxo_telas

import android.R.attr.name
import android.R.attr.type
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavHost
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
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
                        startDestination = "login",

                        exitTransition = {
                            slideOutOfContainer(
                                towards = AnimatedContentTransitionScope.SlideDirection.Left,
                                animationSpec = tween(1000)
                            ) + fadeOut(animationSpec = tween(1000))
                        },

                        enterTransition = {
                            slideIntoContainer(
                                towards = AnimatedContentTransitionScope.SlideDirection.Left,
                                animationSpec = tween(1000)
                            )
                        }
                    ){

                        composable(
                            route = "login",

                            exitTransition = {
                                slideOutOfContainer(
                                    towards = AnimatedContentTransitionScope.SlideDirection.Up,
                                    animationSpec = tween(1000)
                                )
                            },
                        ) {

                            TelaLogin(
                                modifier      = Modifier.padding(innerPadding),
                                navController = navController
                            )
                        }

                        composable(route = "menu") {
                            TelaMenu(modifier = Modifier.padding(innerPadding), navController)
                        }

                        composable(route = "pedidos?numeroPedido={numeroPedido}",

                            arguments = listOf(
                                navArgument(name = "numeroPedido"){
                                    defaultValue = "Sem Pedido"
                                }
                            )

                        ) {
                            val numeroPedido= it.arguments?.getString("numeroPedido")

                            TelaPedido(
                                modifier      = Modifier.padding(innerPadding),
                                navController = navController,
                                numeroPedido  = numeroPedido!!
                                )
                        }

                        composable(
                            route = "perfil/{nome}/{idade}",

                            arguments = listOf(

                                navArgument(name = "nome"){
                                    type = NavType.StringType
                                },

                                navArgument(name = "idade"){
                                    type = NavType.IntType
                                }
                            )

                        ) {

                            val nome  = it.arguments?.getString("nome")
                            val idade = it.arguments?.getInt("idade")

                            TelaPerfil(
                                modifier      = Modifier.padding(innerPadding),
                                navController = navController,
                                nomeUsuario   = nome!!,
                                idade         = idade!!
                            )
                        }
                    }
                }
            }
        }
    }
}
