package com.example.countries.data.repository

import com.example.countries.data.remote.CountriesApi
import com.example.countries.domain.model.CountriesListItem
import com.example.countries.domain.repository.CountriesRepository

import javax.inject.Inject

class CountriesRepositoryImpl @Inject constructor(
    private val countriesApi: CountriesApi
): CountriesRepository {
    override suspend fun getCountriesList(): List<CountriesListItem> {
        return countriesApi.getCountriesList().map { it.toCountriesListItem() }

    }

}