package com.birdushenin.listofusers

import androidx.recyclerview.widget.DiffUtil


class UsersItemDiffCallback : DiffUtil.ItemCallback<Users>() {

    override fun areItemsTheSame(oldItem: Users, newItem: Users): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Users, newItem: Users): Boolean {
        return oldItem == newItem
    }
}