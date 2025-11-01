package com.example.praktikum4

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun FormDataDiri2(modifier: Modifier = Modifier) {
    var textNama by remember { mutableStateOf("") }
    var textAlamat by remember { mutableStateOf("") }
    var textJK by remember { mutableStateOf("") }
    var textStatus by remember { mutableStateOf("") }

    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var jenis by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("") }

    var showDialog by remember { mutableStateOf(false) }

    val gender: List<String> = listOf("Laki-laki", "Perempuan")
    val statusPerkawinan: List<String> = listOf("Janda", "Lajang", "Duda")

    val purpleBackground = Color(0xFFE6D5F5)
    val purpleButton = Color(0xFF7C3AED)
    val purpleHeader = Color(0xFFB794F6)

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(purpleBackground)
            .padding(horizontal = 16.dp, vertical = 16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Formulir Pendaftaran",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .background(purpleHeader, shape = RoundedCornerShape(8.dp))
                .padding(16.dp)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
                .background(Color.White, shape = RoundedCornerShape(12.dp))
                .padding(16.dp)
        ){
            Text(
                text = "NAMA LENGKAP",
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Gray,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            OutlinedTextField(
                value = textNama,
                singleLine = true,
                shape = RoundedCornerShape(8.dp),
                placeholder = { Text(text = "Isian nama lengkap", color = Color.Gray) },
                onValueChange = {
                    textNama = it
                },
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedBorderColor = Color.LightGray,
                    unfocusedBorderColor = Color.LightGray
                )
            )
            Text(
                text = "JENIS KELAMIN",
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Gray,
                modifier = Modifier.padding(top = 20.dp, bottom = 8.dp)
            )
            Column {
                gender.forEach { item ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .selectable(
                                selected = textJK == item,
                                onClick = { textJK = item }
                            )
                            .padding(vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = textJK == item,
                            onClick = {
                                textJK = item
                            }
                        )
                        Text(text = item, modifier = Modifier.padding(start = 8.dp))
                    }
                }
            }
            Text(
                text = "STATUS PERKAWINAN",
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Gray,
                modifier = Modifier.padding(top = 20.dp, bottom = 8.dp)
            )
            Column {
                statusPerkawinan.forEach { item ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .selectable(
                                selected = textStatus == item,
                                onClick = { textStatus = item }
                            )
                            .padding(vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = textStatus == item,
                            onClick = {
                                textStatus = item
                            }
                        )
                        Text(text = item, modifier = Modifier.padding(start = 8.dp))
                    }
                }
            }
            Text(
                text = "ALAMAT",
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Gray,
                modifier = Modifier.padding(top = 20.dp, bottom = 8.dp)
            )
            OutlinedTextField(
                value = textAlamat,
                singleLine = true,
                placeholder = { Text(text = "Alamat", color = Color.Gray) },
                shape = RoundedCornerShape(8.dp),
                onValueChange = {
                    textAlamat = it
                },
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedBorderColor = Color.LightGray,
                    unfocusedBorderColor = Color.LightGray
                )
            )
        }
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp)
                .height(50.dp),
            enabled = textNama.isNotEmpty() && textJK.isNotEmpty() &&
                    textStatus.isNotEmpty() && textAlamat.isNotEmpty(),
            onClick = {
                nama = textNama
                jenis = textJK
                status = textStatus
                alamat = textAlamat
                showDialog = true // Tampilkan pop-up
            },
            shape = RoundedCornerShape(25.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = purpleButton,
                disabledContainerColor = purpleButton.copy(alpha = 0.5f)
            )
        ) {
            Text(
                text = "Submit",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = {
                    Text(
                        text = "Data Pendaftaran",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                },
                text = {
                    Column {
                        Text(text = "Nama : $nama", fontSize = 14.sp)
                        Text(
                            text = "Gender : $jenis",
                            fontSize = 14.sp,
                            modifier = Modifier.padding(top = 4.dp)
                        )
                        Text(
                            text = "Status : $status",
                            fontSize = 14.sp,
                            modifier = Modifier.padding(top = 4.dp)
                        )
                        Text(
                            text = "Alamat : $alamat",
                            fontSize = 14.sp,
                            modifier = Modifier.padding(top = 4.dp)
                        )
                    }
                },
                confirmButton = {
                    TextButton(
                        onClick = {
                            // Reset semua field input
                            textNama = ""
                            textAlamat = ""
                            textJK = ""
                            textStatus = ""
                            showDialog = false
                        }
                    ) {
                        Text("OK", color = purpleButton, fontWeight = FontWeight.Bold)
                    }

                },
                containerColor = Color.White,
                shape = RoundedCornerShape(16.dp)
            )

        }
    }

}



