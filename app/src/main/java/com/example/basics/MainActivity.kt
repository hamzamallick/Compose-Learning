package com.example.basics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.basics.A_Fundamental.AnnotatedStringListnerSample
import com.example.basics.A_Fundamental.FilledButton
import com.example.basics.A_Fundamental.PartiallySelectableText
import com.example.basics.A_Fundamental.TonalButton
import com.example.basics.C_Tools.AlertDialogExample
import com.example.basics.C_Tools.BottomSheet
import com.example.basics.C_Tools.CheckBoxExample
import com.example.basics.C_Tools.ElevatedCard
import com.example.basics.C_Tools.FloatingButton
import com.example.basics.C_Tools.ProgressIndicatorExample
import com.example.basics.D_MenuBox.MenuBox
import com.example.basics.I_PassingData.NavGraph
import com.example.basics.J_NestedNavi.Navigation.NavLogin
import com.example.basics.Z_Projects.LazyNavigate.Navigation.NavigationItem
import com.example.basics.Z_Projects.Login
import com.example.basics.Z_Projects.Tasbee
import com.example.basics.ui.theme.BasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BasicsTheme {

                Box(modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center){

                    NavigationItem()

                }





            }
        }
    }
}

