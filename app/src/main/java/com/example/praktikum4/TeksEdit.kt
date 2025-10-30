package com.example.praktikum4

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun FormDataDiri(modifier: Modifier)
{
    var textNama by remember { mutableStateOf("") }
    var textAlamat by remember { mutableStateOf("") }
    var textJK by remember { mutableStateOf("") }

}