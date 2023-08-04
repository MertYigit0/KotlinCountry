package com.example.kotlincountry.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.get
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlincountry.CountryNavigationArgs
import com.example.kotlincountry.R
import com.example.kotlincountry.adapter.CountryAdapter
import com.example.kotlincountry.databinding.FragmentCountryBinding
import com.example.kotlincountry.databinding.FragmentFeedBinding
import com.example.kotlincountry.viewmodel.CountryViewModel
import com.example.kotlincountry.viewmodel.FeedViewModel


class CountryFragment : Fragment() {
    private var _binding: FragmentCountryBinding? = null;
    private val binding get() = _binding!!;

    private  var countryUuid = 0

    private  lateinit var viewModel: CountryViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        _binding = FragmentCountryBinding.inflate(inflater,container,false)
        val view = binding.root;
        return view

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel = ViewModelProvider(this)[CountryViewModel::class.java]
        viewModel.getDataFromRoom()



        observeLiveData()




        arguments?.let {
            countryUuid = CountryNavigationArgs.fromBundle(it).countryUuid


        }
    }

   private fun observeLiveData(){
        viewModel.countryLiveData.observe(viewLifecycleOwner, Observer {country ->

            country?.let {
                binding.countryName.text = country.countryName
                binding.countryCapital.text = country.countryCapital
                binding.countryCurrency.text = country.countryCurrency
                binding.countryLanguage.text = country.countryLanguage
                binding.countryRegion.text = country.countryRegion




            }
        })



}
}