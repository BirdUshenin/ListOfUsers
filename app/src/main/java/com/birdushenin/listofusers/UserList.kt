package com.birdushenin.listofusers

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
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

        setFragmentResultListener("result_key") { _, result ->
            val data = result.getString("data")
            view?.findViewById<TextView>(R.id.name)?.text = data
        }
        setFragmentResultListener("result_key2") { _, result2 ->
            val data = result2.getString("data")
            view?.findViewById<TextView>(R.id.surname)?.text = data
        }
        setFragmentResultListener("result_key3") { _, result3 ->
            val data = result3.getString("data")
            view?.findViewById<TextView>(R.id.number)?.text = data
        }

        adapter.setOnUserItemClickListener(object : OnUserItemClickListener {
            override fun onUserItemClicked(user: Users) {
                val fragmentB = EditUserFragment()
                fragmentB.setOnUserEditListener(this@UserList)
                fragmentB.setUser(user)

                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.fragEdit, fragmentB)
                    .addToBackStack("FragEdit")
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