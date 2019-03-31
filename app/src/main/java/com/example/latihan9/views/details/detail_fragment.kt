package com.example.latihan9.views.details

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.latihan9.R
import com.example.latihan9.StartApp
import com.example.latihan9.data.data_model.People
import com.example.latihan9.views.add.FragmentaddPeople
import kotlinx.android.synthetic.main.fragment_details.*

class detail_fragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_details,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val peopleId = activity?.intent?.getIntExtra(getString(R.string.people_id),0)
        peopleId?.let {
            val peopleDetails = (activity?.application as StartApp).getPeopleRepo().findPeople(peopleId)
            populatePeopleDetails(peopleDetails)
        }
    }
    private fun populatePeopleDetails(people: People?){
        textViewname.text = people?.name
        textViewmeat.text = people?.meat_at
        buttoncontact.text = people?.contact
        textViewEmail.text = people?.email
        facebook.text = people?.facebook
        twiter.text = people?.twiter
    }
}