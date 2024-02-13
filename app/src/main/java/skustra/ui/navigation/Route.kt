package skustra.ui.navigation

sealed class UserScreen(val route : String) {
    data object Login : UserScreen("login")
    data object Register : UserScreen("register")
    data object RemindPassword : UserScreen("remind_password")
    data object ChangePassword : UserScreen("change_password")
    data object PrivacyPolicy : UserScreen("privacy_policy")
    data object Regulations : UserScreen("regulations")
    data object Agreements : UserScreen("agreements")
    data object ProfileSettings : UserScreen("profile_settings")
}

sealed class UserInterfaceScreen(val route : String) {
    data object CustomizeTheme : UserInterfaceScreen("customize_screen")
    data object MaterialDialog : UserInterfaceScreen("material_dialog")
    data object CustomDialog : UserInterfaceScreen("custom_dialog")
    data object BottomSheetDialog : UserInterfaceScreen("bottom_sheet_dialog")
    data object Splash : UserInterfaceScreen("splash")
    data object OnBoarding : UserInterfaceScreen("on_boarding")
}


