package br.com.fourvrstudios.aula6_retrofitdemo.Network

import androidx.lifecycle.MutableLiveData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("ws/{cep}/json")
    suspend fun getEnderecoByCep(@Path("cep") meuCep: String) : Response<Endereco>
}