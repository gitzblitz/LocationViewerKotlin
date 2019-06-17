package com.gitzblitz.locationviewerkotlin.locationlist

import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.gitzblitz.locationviewerkotlin.R
import com.gitzblitz.locationviewerkotlin.locationlist.LocationListAdapter.LocationViewHolder.Companion.DIFF_CALLBACK
import com.gitzblitz.locationviewerkotlin.model.Location

class LocationListAdapter : PagedListAdapter<Location, LocationListAdapter.LocationViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationListAdapter.LocationViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.location_list_item, parent, false)
        return LocationViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: LocationListAdapter.LocationViewHolder, position: Int) {
        val location = getItem(position)
        if (location != null) {
            holder.bindTo(location)
        } else {
            holder.clear()
        }
    }

    class LocationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnCreateContextMenuListener {
        var locationNameTextView = itemView.findViewById<TextView>(R.id.location_name)
        var locationDescriptionTextView = itemView.findViewById<TextView>(R.id.location_description)
        var locationLayout = itemView.findViewById<LinearLayout>(R.id.location_layout)

        fun bindTo(location: Location) {
            locationDescriptionTextView.text = location.description
            locationNameTextView.text = location.name
            locationLayout.setOnCreateContextMenuListener(this)

        }

        override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
            menu?.let {
                it.setHeaderTitle("Choose option")
                it.add(this.adapterPosition, 121, 0, "Edit location")
            }
        }

        fun clear() {
        }

        companion object {
            val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Location>() {
                override fun areItemsTheSame(oldItem: Location, newItem: Location) = oldItem.uid == newItem.uid
                override fun areContentsTheSame(oldItem: Location, newItem: Location)  =  oldItem == newItem

            }
        }
    }
}