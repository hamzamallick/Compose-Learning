package com.example.basics.J_NestedNavi.Navigation

sealed class Screens(val route : String) {

    object ScreenLoginRoute : Screens(route = "Login")
    object ScreenRegisterRoute : Screens(route = "Register")
    object ScreenForgetRoute : Screens(route = "ForgetPass")
    object ScreenHomeRoute : Screens(route = "Home")
    object ScreenARoute : Screens(route = "A")
    object ScreenBRoute : Screens(route = "B")
    object AuthRoute : Screens(route = "Auth")
    object AppRoute : Screens(route = "App")
}