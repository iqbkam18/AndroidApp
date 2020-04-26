package com.example.NavigationApp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageButton
import androidx.recyclerview.widget.RecyclerView
import com.example.NavigationApp.IOnclickListener
import com.example.NavigationApp.R
import com.example.NavigationApp.model.Feature
import kotlinx.android.synthetic.main.places_row.view.*
import kotlin.collections.ArrayList

class PlacesAdapter(
    private var places: List<Feature>,
    private val mClickListener: IOnclickListener
) :
    RecyclerView.Adapter<PlacesAdapter.ViewHolder>(), Filterable {


    var placesFilteredList: List<Feature> = places
   // val placesListFull: List<Feature> = places


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.places_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = places.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindViewHolderItem(places[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val button = itemView.findViewById<ImageButton>(R.id.icon_location)
        fun bindViewHolderItem(item: Feature) {
            itemView.placeName.text = item.properties.name
            itemView.icon_location.setOnClickListener {
                mClickListener.onIconClick(
                    item.geometry.coordinates[0],
                    item.geometry.coordinates[1]
                )
            }

            itemView.setOnClickListener {
                mClickListener.onItemClick(item.properties.id)
            }
        }

    }


    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                val tempList = placesFilteredList
                val searchResult: MutableList<Feature> = ArrayList()
                val filterResults = FilterResults()
                if (constraint!!.isEmpty())  {
                    searchResult.addAll(tempList)
                } else {
                    for (place in tempList) {
                        if (place.properties.name.contains(charSearch, ignoreCase = true)) {
                            searchResult.add(place)
                        }
                    }
                }
                placesFilteredList = searchResult

                filterResults.values = placesFilteredList
                return filterResults
            }


            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                val resultList: List<Feature> = results?.values as List<Feature>
                if (!resultList.isNullOrEmpty()) {
                    places = resultList
                    notifyDataSetChanged()
                }
            }

        }

    }

}




