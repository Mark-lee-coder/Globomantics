package com.example.globomantics.ui.clients

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.globomantics.R
import com.example.globomantics.databinding.FragmentClientsBinding.*

class ClientsFragment : Fragment(), ClientsAdapter.OnClickListener {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_clients, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val clientsViewModel =
            ViewModelProvider(this)[ClientsViewModel::class.java]
        val adapter = ClientsAdapter(this)
        listClients.layoutManager = LinearLayoutManager(activity)
        listClients.adapter = adapter
        clientsViewModel.allClients.observe(viewLifecycleOwner, Observer {
            adapter.setClients(it)
        })
    }

    override fun onClick(id: Int) {
        val action = ClientsFragmentDirections.openClient()
        action.clientId = id
        val navController = Navigation.findNavController(requireView())
        navController.navigate(action)
    }
}