package br.com.fourvrstudios.aula6_retrofitdemo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fourvrstudios.aula6_retrofitdemo.Network.Endereco
import br.com.fourvrstudios.aula6_retrofitdemo.Network.RetrofitInstance
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

enum class RestApiStatus { LOADING, ERROR, DONE }

class RetrofitViewModel : ViewModel() {

    private val _status = MutableLiveData<RestApiStatus>()
    val status : LiveData<RestApiStatus>
        get() = _status

    private val _responseEndereco = MutableLiveData<Endereco>()
    val responseEndereco: LiveData<Endereco>
        get() = _responseEndereco

    private val _cep = MutableLiveData<String>()
    val cep: LiveData<String>
        get() = _cep

    fun getEndereco(numCep : String) : Job =
        viewModelScope.launch {
            try {
                _status.value = RestApiStatus.LOADING
                _responseEndereco.value = RetrofitInstance.retrofit.getEnderecoByCep(numCep).body()
                Log.i("MYTAG", "Está chamando corretamente")
                _status.value = RestApiStatus.DONE
            } catch (e: Exception) {
                Log.i("MYTAG", "Error")
                _status.value = RestApiStatus.ERROR
            }
        }

    override fun onCleared() {
        super.onCleared()
    }
}