package com.birdushenin.listofusers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class EditUserFragment : Fragment() {

//    companion object {
//        fun newInstance(user: Users): EditUserFragment {
//            val fragment = EditUserFragment()
//            val args = Bundle()
//            args.putSerializable("user", user)
//            fragment.arguments = args
//            return fragment
//        }
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit_user, container, false)
    }
}