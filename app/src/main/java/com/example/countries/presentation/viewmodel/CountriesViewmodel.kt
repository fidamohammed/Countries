package com.example.countries.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.countries.domain.model.CountriesListItem
import com.example.countries.domain.repository.CountriesRepository
import com.example.countries.util.NetworkState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class CountriesViewmodel @Inject constructor(
    private val countriesRepository: CountriesRepository
): ViewModel() {

    private var _countriesResponse: MutableStateFlow<NetworkState<List<CountriesListItem>>> =
        MutableStateFlow(NetworkState.Loading())
    val countriesResponse: StateFlow<NetworkState<List<CountriesListItem>>> get() = _countriesResponse

    fun getCountriesList(){
        viewModelScope.launch {
            try {
                val result = countriesRepository.getCountriesList()
                if(result.isEmpty()){
                    _countriesResponse.value = NetworkState.Error("Empty Response")
                }
                else{
                    _countriesResponse.value = NetworkState.Success(result)
                }
            }catch (e: Exception){
                    _countriesResponse.value = NetworkState.Error("Something went wrong: ${e.message}")
            }

        }

    }
}