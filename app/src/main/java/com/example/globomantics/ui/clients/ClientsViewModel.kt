package com.example.globomantics.ui.clients

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.globomantics.data.Client
import com.example.globomantics.data.ClientRepository
import com.example.globomantics.data.ClientRoomDatabase
import com.example.globomantics.data.ClientRoomRepository

class ClientsViewModel(application: Application) : AndroidViewModel(application) {
    private val clientRepository: ClientRepository

    init {
        val clientDao = ClientRoomDatabase.getInstance(application).clientDao()
        clientRepository = ClientRoomRepository(clientDao)
    }

    val allClients: LiveData<List<Client>> = clientRepository.getAllClients()
}