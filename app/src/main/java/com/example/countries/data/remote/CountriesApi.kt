package com.example.countries.data.remote

import com.example.countries.data.remote.dto.CountriesListItemdto
import retrofit2.Response
import retrofit2.http.GET

interface CountriesApi {
    @GET("peymano-wmt/32dcb892b06648910ddd40406e37fdab/raw/db25946fd77c5873b0303b858e861ce724e0dcd0/countries.json")
    suspend fun getCountriesList(): ArrayList<CountriesListItemdto>
}