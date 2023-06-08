package com.example.globomantics.ui.add

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.globomantics.data.Client
import com.example.globomantics.data.ClientRepository
import com.example.globomantics.data.ClientRoomDatabase
import com.example.globomantics.data.ClientRoomRepository
import kotlinx.coroutines.launch

class AddViewModel(application: Application) : AndroidViewModel(application) {
    private val clientRepository: ClientRepository

    init {
        val clientDao = ClientRoomDatabase.getInstance(application).clientDao()
        clientRepository = ClientRoomRepository(clientDao)
    }

    fun insert(client: Client) = viewModelScope.launch {
        clientRepository.insert(client)
    }
}