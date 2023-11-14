package com.birdushenin.listofusers

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.FragmentContainerView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.birdushenin.listofusers.databinding.FragmentUserListBinding

class UserList : Fragment() {

    private lateinit var adapter: AdapterUsers

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
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.fragEdit, fragmentB)
                    .addToBackStack("FragmentB")
                    .commit()
            }
        })

        recyclerView.adapter = adapter
        return binding.root
    }
}