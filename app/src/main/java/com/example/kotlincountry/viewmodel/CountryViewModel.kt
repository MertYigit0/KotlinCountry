package com.example.kotlincountry.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlincountry.model.Country

class CountryViewModel: ViewModel() {

    val countryLiveData = MutableLiveData<Country>()


    fun getDataFromRoom(){
        val country = Country("Turkey","Asia","TRY","TRY","Turkish","www.ss.com")
        countryLiveData.value = country
    }



}