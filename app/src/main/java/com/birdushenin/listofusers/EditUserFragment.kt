package com.birdushenin.listofusers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.birdushenin.listofusers.databinding.FragmentEditUserBinding

interface OnUserEditListener {
    fun onUserEdited(user: Users)
}

class EditUserFragment : Fragment() {

    private lateinit var user: Users
    private lateinit var onUserEditListener: OnUserEditListener
    private lateinit var binding: FragmentEditUserBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEditUserBinding.inflate(inflater)

        val editTextName = binding.editTextName
        val editSurname = binding.editSurname
        val editTextNumber = binding.editTextNumber

        val buttonEditUser = binding.buttonEditUser
        buttonEditUser.setOnClickListener {
            val updatedUser = Users(
                user.id,
                user.photo,
                editTextName.text.toString(),
                editSurname.text.toString(),
                editTextNumber.text.toString()
            )
            onUserEditListener.onUserEdited(updatedUser)
        }
        return binding.root
    }
    fun setOnUserEditListener(listener: OnUserEditListener) {
        onUserEditListener = listener
    }
    fun setUser(user: Users) {
        this.user = user
        if (::binding.isInitialized) {
            binding.editTextName.setText(user.name)
            binding.editSurname.setText(user.surname)
            binding.editTextNumber.setText(user.phoneNumber)
        }
    }
}