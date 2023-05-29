package com.example.lemonade
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonade.ui.theme.LemonadeTheme
import androidx.compose.material.Text
import androidx.compose.ui.Alignment


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LemonApp()
                }
            }
        }
    }
}

@Composable
fun LemonApp( modifier: Modifier = Modifier) {
    var result by remember { mutableStateOf(1) }

    println("*******************************************************")
println(result)
    val imageResource = when(result) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        4 -> R.drawable.lemon_restart
        else -> R.drawable.lemon_tree
    }

    val descriptionResource = when(result) {
        1 -> R.string.lemon_tree
        2 -> R.string.lemon_squeeze
        3 -> R.string.glass_of_lemonade
        4 -> R.string.empty_glass
        else -> R.string.lemon_tree
    }



    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Spacer(modifier = Modifier.height(16.dp))

        TextButton(

            onClick = {
            result = (1..4).random()

        }) {
            Image(painter = painterResource(imageResource), contentDescription = result.toString() )


        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text=  stringResource(descriptionResource),
            color= Color.White

        )
    }
    }




@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LemonadeTheme {
        LemonApp()
    }
}


