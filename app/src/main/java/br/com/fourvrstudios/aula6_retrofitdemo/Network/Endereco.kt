package br.com.fourvrstudios.aula6_retrofitdemo.Network

import com.squareup.moshi.Json

data class Endereco(
    @Json(name = "bairro")
    val bairro: String,
    @Json(name = "localidade")
    val localidade: String,
    @Json(name = "logradouro")
    val logradouro: String,
    @Json(name = "uf")
    val uf: String
)