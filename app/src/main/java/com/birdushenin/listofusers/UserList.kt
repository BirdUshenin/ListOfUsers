package com.birdushenin.listofusers

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.birdushenin.listofusers.databinding.FragmentUserListBinding

class UserList : Fragment(), OnUserEditListener {

    private lateinit var adapter: AdapterUsers

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val userServer = DataUsers.userServer
        adapter = AdapterUsers(userServer)

        val binding = FragmentUserListBinding.inflate(inflater)

        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

            adapter.setOnUserItemClickListener(object: OnUserItemClickListener {
            override fun onUserItemClicked(user: Users) {
                val fragmentB = EditUserFragment()
                fragmentB.setOnUserEditListener(this@UserList)
                fragmentB.setUser(user)

                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.fragEdit, fragmentB)
                    .addToBackStack("FragmentB")
                    .commit()
            }
        })
        recyclerView.adapter = adapter
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onUserEdited(user: Users) {
        val index = DataUsers.userServer.indexOfFirst { it.id == user.id }
        if (index != -1) {
            DataUsers.userServer[index] = user
            adapter.notifyDataSetChanged()
        }
    }
}