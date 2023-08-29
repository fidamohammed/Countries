package com.example.countries.data.remote.dto

import com.example.countries.domain.model.CountriesListItem

data class CountriesListItemdto(
    val capital: String,
    val code: String,
    val currency: Currencydto,
    val demonym: String,
    val flag: String,
    val language: Languagedto,
    val name: String,
    val region: String
){
    fun toCountriesListItem(): CountriesListItem{
        return CountriesListItem(
            capital, code, name, region
        )
    }
}