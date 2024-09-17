package edu.unicauca.estadosjetpackcompose

import android.os.Bundle
import android.view.Surface
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edu.unicauca.estadosjetpackcompose.ui.theme.EstadosJetPackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EstadosJetPackComposeTheme {
                Surface {
                    MainContador()
                }
            }
        }
    }
}

@Composable
fun MainContador(){
    var contador by rememberSaveable{ mutableStateOf(0) }
    Column(modifier =
    Modifier
        .fillMaxSize()
        .padding(top = 60.dp, start = 20.dp, end = 20.dp))
    {
        //Text(text= "Contador = $contador")
        TextoContador(contador)
        Contador(tituloBt = "Incrementar", onIncrementar = {contador++})
        Contador(tituloBt = "Decrementar", onIncrementar = {contador--})
        Contador(tituloBt = "Resetear", onIncrementar = {contador=0})
        BotonTexto(titulo = "Multiplicar", onIncrementar = {contador*=2})

    }
}

@Composable
fun BotonTexto(titulo:String, onIncrementar: () -> Unit){
    Column {
        Text(text = titulo)
        Contador(tituloBt = "Multiplicador", onIncrementar = {onIncrementar()})
    }
}

@Composable
fun TextoContador(contador:Int){
    Column {
        if(contador>0){
            Text(text = "Contador Actual")
            Text(text = "$contador")
        }else{
            Text(text = "Contador Vacio")
        }

    }
}

//Composable stateless
@Composable
fun Contador(tituloBt:String, onIncrementar: () -> Unit){
    Button(
        onClick = {
            onIncrementar()
        }) {
        Text(text = tituloBt)
    }
}





//Otro ejemplo con campo de texto
@Composable
private fun HelloContent() {
    var name by rememberSaveable{ mutableStateOf("") }
    Column(modifier = Modifier.padding(top = 60.dp)) {
        if(name.isNotEmpty()){
            Text(
                text = "Hola $name",
                modifier = Modifier.padding(bottom = 8.dp),
                style = MaterialTheme.typography.bodyMedium
            )
        }

        OutlinedTextField(
            value = name,
            onValueChange = {name = it },
            label = { Text("Name") }
        )
    }
}