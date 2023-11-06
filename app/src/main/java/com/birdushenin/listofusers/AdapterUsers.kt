package com.birdushenin.listofusers

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter

class AdapterUsers(private val userList: List<Users>) : ListAdapter<Users, UsersItemViewHolder>(UsersItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return UsersItemViewHolder(view)
    }
    override fun onBindViewHolder(holder: UsersItemViewHolder, position: Int) {
        holder.bind(userList[position])
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}