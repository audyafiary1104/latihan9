package com.example.latihan9.views.add

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.latihan9.R
import com.example.latihan9.StartApp
import com.example.latihan9.data.data_model.People
import kotlinx.android.synthetic.main.fragment_add_people.*

class FragmentaddPeople : Fragment() {
    lateinit var btn_ : Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        var view : View = inflater.inflate(R.layout.fragment_add_people,
            container, false)
        btn_ = view.findViewById(R.id.btn_)
        return view
    }


    private fun savePeopleinfo(){
        val people = People(
            textinputname.editText?.text.toString(),
            textinputemail.editText?.text.toString(),
            textinputcontact.editText?.text.toString(),
            textmeat.editText?.text.toString(),
            facebook.editText?.text.toString(),
            twiter.editText?.text.toString()
            )
        (activity?.application as StartApp).getPeopleRepo().insertPeople(people)
        activity?.finish()

    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        btn_.setOnClickListener {
            savePeopleinfo()
        }
    }
}