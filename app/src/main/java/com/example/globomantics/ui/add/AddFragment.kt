package com.example.globomantics.ui.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.globomantics.MainActivity
import com.example.globomantics.R
import com.example.globomantics.data.Client
import com.example.globomantics.databinding.ActivityMainBinding
import com.example.globomantics.databinding.FragmentAddBinding.*

class AddFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_add, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        val addViewModel = ViewModelProvider(this)[AddViewModel::class.java]

        btnSave.setOnClickListener {
            addViewModel.insert(
                Client(
                    date = System.currentTimeMillis(),
                    name = txtName.text.toString(),
                    order = txtOrder.text.toString(),
                    terms = txtTerms.text.toString()
                )
            )
            (activity as MainActivity).hideKeyboard()
            val navController = Navigation.findNavController(view)
            navController.navigate(AddFragmentDirections.backToClients())
        }
    }
}