package br.senai.sp.jandira.contatos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.contatos.ui.theme.ContatosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ContatosTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FormularioCadastro()
                }
            }
        }
    }
}

@Composable
fun FormularioCadastro() {

    var nomeState = remember {
        mutableStateOf("")
    }
    var phoneState = remember {
        mutableStateOf("")
    }
    var emailState = remember {
        mutableStateOf("")
    }
    var dataNascimentoState = remember {
        mutableStateOf("")
    }
    var familiaState = remember {
        mutableStateOf(false)
    }

    Column {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = stringResource(id = R.string.title),
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Magenta
            )
            Spacer(modifier = Modifier.height(32.dp))
            OutlinedTextField(
                value = nomeState.value,
                onValueChange ={
                               nomeState.value = it
                },
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(text = stringResource(id = R.string.contact_name ))
                }
            )
            OutlinedTextField(
                value = phoneState.value,
                onValueChange ={
                               phoneState.value = it
                },
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(text = stringResource(id = R.string.contact_phone ))
                }
            )
            OutlinedTextField(
                value = emailState.value,
                onValueChange ={
                               emailState.value = it
                },
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(text = stringResource(id = R.string.contact_email ))
                }
            )
            OutlinedTextField(
                value = dataNascimentoState.value,
                onValueChange ={
                               dataNascimentoState.value = it
                },
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(text = stringResource(id = R.string.contact_date_of_birth))
                }
            )
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                Checkbox(checked = familiaState.value, onCheckedChange = {familiaState.value = it})
                Text(text = stringResource(id = R.string.family))
            }
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = stringResource(id = R.string.save))
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    ContatosTheme {
        FormularioCadastro()
    }
}