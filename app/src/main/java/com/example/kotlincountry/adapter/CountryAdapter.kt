package com.example.kotlincountry.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlincountry.R
import com.example.kotlincountry.model.Country
import com.example.kotlincountry.util.downnloadFromUrl
import  com.example.kotlincountry.util.placeholderProgressBar
import com.example.kotlincountry.view.FeedFragmentDirections
import okhttp3.internal.Util

class CountryAdapter(val countryList: ArrayList<Country>):RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    class CountryViewHolder(var view:View):RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
      val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_country,parent,false)
        return CountryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val currentCountry = countryList[position]

        holder.view.findViewById<TextView>(R.id.name).text = currentCountry.countryName
        holder.view.findViewById<TextView>(R.id.region).text = currentCountry.countryRegion


        holder.view.setOnClickListener{
            val uuid = countryList[position].uuid ?: -1
            val action = FeedFragmentDirections.actionFeedFragmentToCountryFragment(uuid)

            Navigation.findNavController(it).navigate(action)

        }
        holder.view.findViewById<ImageView>(R.id.imageView).downnloadFromUrl(currentCountry.imageUrl,
            placeholderProgressBar(holder.view.context))




    }

    fun updateCountryList(newCountryList : List<Country>){
        countryList.clear()
        countryList.addAll(newCountryList)
        notifyDataSetChanged()
    }


}