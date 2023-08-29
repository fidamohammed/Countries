package com.example.countries.domain.repository

import com.example.countries.domain.model.CountriesListItem
import com.example.countries.util.NetworkState
import kotlinx.coroutines.flow.Flow

interface CountriesRepository {
    suspend fun getCountriesList(): List<CountriesListItem>
}