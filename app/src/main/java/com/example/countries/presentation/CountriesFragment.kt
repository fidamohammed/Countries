package com.example.countries.presentation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.countries.R
import com.example.countries.databinding.FragmentCountriesBinding
import com.example.countries.presentation.viewmodel.CountriesViewmodel
import com.example.countries.util.NetworkState
import com.google.android.material.progressindicator.CircularProgressIndicator
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CountriesFragment : Fragment() {

    private lateinit var binding: FragmentCountriesBinding
    private lateinit var countriesAdapter: CountriesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCountriesBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel =  ViewModelProvider(this).get(CountriesViewmodel::class.java)

        binding.rvCountriesList.apply {
            layoutManager = LinearLayoutManager(requireContext())
        }
        viewModel.getCountriesList()
        viewModel.countriesResponse.asLiveData().observe(viewLifecycleOwner){state->
            when(state){
                is NetworkState.Loading -> {
                    Log.d("CountriesData", " Data Loading")
                    CircularProgressIndicator.VISIBLE
                }
                is NetworkState.Success -> {
                   state.data?.let {
                       countriesAdapter = CountriesAdapter(it)
                       binding.rvCountriesList.adapter=countriesAdapter
                   }
                }
                is NetworkState.Error -> {
                   Toast.makeText(requireContext(),"${state.message}",Toast.LENGTH_SHORT).show()
                }
            }
        }



    }


}