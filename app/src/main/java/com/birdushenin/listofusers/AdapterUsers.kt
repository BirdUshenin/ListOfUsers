package com.birdushenin.listofusers

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter

class AdapterUsers(private val userList: List<Users>) :
    ListAdapter<Users, UsersItemViewHolder>(UsersItemDiffCallback()) {

    var clickListener: OnUserItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return UsersItemViewHolder(view)
    }

    fun setOnUserItemClickListener(listener: OnUserItemClickListener){
        clickListener = listener
    }

    override fun onBindViewHolder(viewHolder: UsersItemViewHolder, position: Int) {
        val user = userList[position]
        viewHolder.bind(user)
        viewHolder.itemView.setOnClickListener {
            clickListener?.onUserItemClicked(user)
        }
    }


    override fun getItemCount(): Int {
        return userList.size
    }
}