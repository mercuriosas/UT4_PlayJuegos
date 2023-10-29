package com.example.ut4_playjuegosv2

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ut4_playjuegosv2.ui.theme.AzulTransp
import com.example.ut4_playjuegosv2.ui.theme.NaranjaLight
import com.example.ut4_playjuegosv2.ui.theme.NaranjaSec


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun MenuNewPlayer() {
    var EstadoNombre by remember { mutableStateOf("") }
    var EstadoApellido by remember { mutableStateOf("") }
    var EstadoNick by remember { mutableStateOf("") }
    var EstadoTelf by remember { mutableStateOf("") }
    var EstadoMail by remember { mutableStateOf("") }
    var nameError by remember { mutableStateOf(false) } // Variable para el control de errores
    var pesoH = 3f
    var pesoV = 1f

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.size(10.dp))
        Column(modifier = Modifier.padding(20.dp)) {
            Row() {
                Image(
                    painter = painterResource(R.drawable.account),
                    contentDescription = "User",
                    Modifier
                        .size(60.dp)
                        .weight(pesoV)
                )
                //Spacer(modifier = Modifier.size(20.dp))
                TextField(
                    value = EstadoNombre,
                    onValueChange = {
                        EstadoNombre = it
                        nameError = false
                    },
                    Modifier.weight(pesoH),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = AzulTransp,
                        focusedIndicatorColor = NaranjaLight
                    ),
                    isError = nameError,
                    label = { Text(text = ("Nombre")) },
                    shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
                )

            }
            Row {
                val assistiveElementText =
                    if (nameError) "Error: Obligatorio" else "*Obligatorio" // 4
                val assistiveElementColor = if (nameError) { // 5
                    MaterialTheme.colorScheme.error
                } else {
                    MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
                }
                Spacer(Modifier.weight(pesoV))
                Text(
                    text = assistiveElementText,
                    color = assistiveElementColor,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.weight(pesoH)
                )
            }
            Spacer(modifier = Modifier.size(10.dp))
            Row() {
                Spacer(
                    modifier = Modifier
                        .weight(pesoV)
                    //.size(80.dp)
                )
                TextField(
                    value = EstadoApellido,
                    onValueChange = { EstadoApellido = it },
                    Modifier
                        .weight(pesoH),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = AzulTransp,
                        focusedIndicatorColor = NaranjaLight
                    ),
                    //.width(280.dp),
                    label = {
                        Text("Apellidos")
                    },
                    shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
                )
            }
            Spacer(modifier = Modifier.size(20.dp))
            Row() {
                Spacer(
                    modifier = Modifier
                        .weight(pesoV)
                    //.size(80.dp)
                )
                /*
                TextField(
                    value = EstadoNick,
                    onValueChange = { EstadoNick = it },
                    Modifier
                        .weight(pesoH),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = AzulTransp,
                        focusedIndicatorColor = NaranjaLight
                    ),
                    //.width(280.dp),
                    label = {
                        Text("Nick")
                    },
                    shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
                )*/
                //Spacer(modifier = Modifier.size(110.dp))
                MyDropDownMenu(pesoH)
            }
            Spacer(Modifier.size(20.dp))
            Row() {
                Spacer(
                    modifier = Modifier
                        .weight(1f)
                )
                Image(
                    painter = painterResource(R.drawable.android),
                    contentDescription = "Carga",
                    Modifier
                        .size(100.dp)
                        .weight(1f)
                    //.weight(pesoV)
                )
                Button(
                    onClick = { },
                    // colors = ButtonDefaults.buttonColors(background = NaranjaSec),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = NaranjaSec,
                        contentColor = Color.Black
                    ),
                    modifier = Modifier
                        .width(100.dp)
                        .weight(1f)
                ) {
                    Text(text = "Change")
                }
            }
            Spacer(Modifier.size(20.dp))
            Row() {
                Image(
                    painter = painterResource(R.drawable.camera),
                    contentDescription = "Cámara",
                    Modifier
                        .size(60.dp)
                        .weight(pesoV)
                )
                // Spacer(modifier = Modifier.size(20.dp))
                TextField(
                    value = EstadoTelf,
                    onValueChange = { EstadoTelf = it },
                    Modifier
                        .weight(pesoH),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = AzulTransp,
                        focusedIndicatorColor = NaranjaLight
                    ),
                    //.width(280.dp),
                    label = {
                        Text("Teléfono")
                    },
                    shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
                )
            }
            Spacer(Modifier.size(20.dp))
            Row() {
                Image(
                    painter = painterResource(R.drawable.email),
                    contentDescription = "Cámara",
                    Modifier
                        .size(60.dp)
                        .weight(pesoV)
                )
                TextField(
                    value = EstadoMail,
                    onValueChange = { EstadoMail = it },
                    Modifier
                        .weight(pesoH),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = AzulTransp,
                        focusedIndicatorColor = NaranjaLight
                    ),
                    //.width(280.dp),
                    label = {
                        Text("E-mail")
                    },
                    shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
                )
            }
        }
        Row() {
            Button(
                onClick = { nameError = EstadoNombre.isBlank() },
                shape = RoundedCornerShape(15.dp)
            ) {
                Text(text = "Add new player")
            }

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyDropDownMenu(peso: Float) {
    var selectedText by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    val usuarios =
        listOf("Blizzard", "Ryu578", "Kinton22", "Sasuke547", "Messi788")

    Column() {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded },
        ) {
            TextField(
                // The `menuAnchor` modifier must be passed to the text field for correctness.
                modifier = Modifier.menuAnchor().weight(peso),
                readOnly = true,
                value = selectedText,
                onValueChange = {},
                label = { Text("Nick") },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                colors = ExposedDropdownMenuDefaults.textFieldColors(
                    containerColor = AzulTransp,
                    focusedIndicatorColor = NaranjaLight
                ),
                shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
            ) {
                usuarios.forEach { selectionOption ->
                    DropdownMenuItem(
                        text = { Text(selectionOption) },
                        onClick = {
                            selectedText = selectionOption
                            expanded = false
                        },
                        contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
                    )
                }
            }
        }
    }
}
/*
@Composable
fun MyDropDownMenu2(peso: Float) {
    var selectedText by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    val series =
        listOf("Blizzard", "Ryu578", "Kinton22", "Sasuke547", "Messi788")

    Column(Modifier.padding(20.dp)) {
        OutlinedTextField(value = selectedText, onValueChange = { selectedText = it },
            enabled = false,
            readOnly = true,
            label = { Text("Nick") },
            modifier = Modifier
                .clickable { expanded = true }
                .background(AzulTransp)
                .width(250.dp),
            shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .background(AzulTransp)
                .width(250.dp),
        ) {
            series.forEach { serie ->
                DropdownMenuItem(onClick =
                {
                    expanded = false
                    selectedText = serie
                }) {
                    Row() {
                        //Icon(imageVector = Icons.Default.Star, contentDescription = "")
                        //Spacer(Modifier.width(10.dp))
                        Text(text = serie, color = Color(0xFFfc7d00))
                    }

                }
            }
        }

    }*/
