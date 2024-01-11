package com.hussein.moko.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.hussein.moko.Greeting
import com.hussein.moko.SharedRes
import com.hussein.moko.Strings
import dev.icerock.moko.resources.StringResource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        //MR mean Moko Resources
                        //SharedRes name in build.gradle.kts(:shared)
                        // multiplatformResources {
                        //    multiplatformResourcesPackage = "com.hussein.moko"
                        //    multiplatformResourcesClassName = "SharedRes"
                        //}
                        Image(painter = painterResource(id = com.hussein.moko.R.drawable.img), contentDescription = null)
                        Text(text = stringResource(id= SharedRes.strings.hello_world))
                        Text(text = stringResource(id= SharedRes.strings.hello_x , "Hussein"))

                    }
                }
            }
        }
    }
}

@Composable
fun stringResource(id:StringResource ,vararg args:Any) : String{
    return Strings(LocalContext.current).get(id,args.toList())
}

@Composable
fun GreetingView(text: String) {
    Text(text = text)
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        GreetingView("Hello, Android!")
    }
}
