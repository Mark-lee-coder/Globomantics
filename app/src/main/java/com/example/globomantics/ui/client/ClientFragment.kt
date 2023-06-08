package com.example.globomantics.ui.client

import android.os.Bundle
import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.globomantics.R
import com.example.globomantics.databinding.FragmentClientBinding.*
import java.util.*

class ClientFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_client, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val clientViewModel = ViewModelProvider(this)[ClientViewModel::class.java]
        arguments?.let { bundle ->
            val passedArguments = ClientFragmentArgs.fromBundle(bundle)
            clientViewModel.getClient(passedArguments.clientId).observe(viewLifecycleOwner, Observer { client ->
                    name.text = client.name
                    order.text = client.order
                    terms.text = client.terms

                    val calendar = Calendar.getInstance()
                    val dateFormat = DateFormat.getDateFormat(view.context)
                    calendar.timeInMillis = client.date
                    date.text = dateFormat.format(calendar.time)
            })
        }
    }
}