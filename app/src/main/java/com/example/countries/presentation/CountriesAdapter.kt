package com.example.countries.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.countries.R
import com.example.countries.databinding.CountryItemBinding
import com.example.countries.databinding.FragmentCountriesBinding
import com.example.countries.domain.model.CountriesListItem

class CountriesAdapter(val countriesList: List<CountriesListItem>): RecyclerView.Adapter<CountriesAdapter.CountriesViewHolder>() {

    inner class CountriesViewHolder(view: View): ViewHolder(view){
        val binding = CountryItemBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesViewHolder {
        return CountriesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.country_item, parent, false))
    }

    override fun getItemCount(): Int {
        return countriesList.size
    }

    override fun onBindViewHolder(holder: CountriesViewHolder, position: Int) {
        val currentCountry = countriesList[position]
        holder.binding.apply {
            tvCountryName.text = currentCountry.name +", "+ currentCountry.region
//            tvCountryRegion.text = currentCountry.region
            tvCountryCode.text = currentCountry.code
            tvCountryCapital.text = currentCountry.capital
        }
    }
}