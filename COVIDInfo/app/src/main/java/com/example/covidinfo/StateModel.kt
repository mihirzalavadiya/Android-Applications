package com.example.covidinfo

data class StateModel (
    val state: String,
    val recovered: Int,
    val deaths: Int,
    val cases: Long
)