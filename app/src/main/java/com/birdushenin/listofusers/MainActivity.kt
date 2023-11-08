package com.birdushenin.listofusers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.birdushenin.listofusers.DataUsers.userServer

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: AdapterUsers
    private lateinit var fragmentEdit: EditUserFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val userServer = DataUsers.userServer
        adapter = AdapterUsers(userServer)

        fragmentEdit = EditUserFragment()

        adapter.setOnUserItemClickListener(object: OnUserItemClickListener {
            override fun onUserItemClicked(user: Users) {
                val transaction = supportFragmentManager.beginTransaction()
//                val args = Bundle()
//                args.putSerializable("user", user)
//                fragmentEdit.arguments = args
                transaction.replace(R.id.fragEdit, fragmentEdit)
                transaction.addToBackStack("FragmentEdit")
                transaction.commit()
            }
        })

        recyclerView.adapter = adapter
    }
}
