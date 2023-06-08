package com.example.globomantics.ui.client

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.globomantics.data.Client
import com.example.globomantics.data.ClientRepository
import com.example.globomantics.data.ClientRoomDatabase
import com.example.globomantics.data.ClientRoomRepository

class ClientViewModel(application: Application) : AndroidViewModel(application) {
    private val clientRepository: ClientRepository

    init {
        val clientDao = ClientRoomDatabase.getInstance(application).clientDao()
        clientRepository = ClientRoomRepository(clientDao)
    }

    fun getClient(id: Int): LiveData<Client> {
        return clientRepository.getClient(id)
    }
}