package com.example.latihan9.views.views_list

import android.app.Fragment
import android.app.FragmentContainer
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.latihan9.R
import com.example.latihan9.StartApp
import com.example.latihan9.data.data_model.People
import com.example.latihan9.views.add.AddPeopleData
import com.example.latihan9.views.details.Detailsact
import kotlinx.android.synthetic.main.act_add_people.*
import kotlinx.android.synthetic.main.fragment_for_list_people.*
import kotlinx.android.synthetic.main.mainlayout.*

class ListPeopleFragment : android.support.v4.app.Fragment(), ListPeopleAdapter.OnItemClickListener {
private lateinit var viewModel: PeopleListViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(PeopleListViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?): View {
    return  inflater.inflate(R.layout.fragment_for_list_people,container,false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addFab.setOnClickListener{
//    Toast.makeText(activity.applicationContext,"Test Click Fab",Toast.LENGTH_SHORT).show()
            val intent = Intent(context, AddPeopleData::class.java)
            startActivity(intent)
        }
        viewModel.getPeopleList().observe(this,Observer<List<People>>{
            peoples -> peoples?.let {
            populatePeopleList(peoples)
        }
        })
    }
    override fun onItemClick(people: People, itemView: View) {
        val detailIntent = Intent(context,Detailsact::class.java)
        detailIntent.putExtra(getString(R.string.people_id),people.id)
        startActivity(detailIntent)
    }
    private fun populatePeopleList(peoplelist: List<People>){
        peopleRecycleview.adapter = ListPeopleAdapter(peoplelist,this)
    }

//    override fun onResume() {
//        super.onResume()
////        val people = (activity?.application as StartApp).getPeopleRepo().getAllPeople()
////        populatePeopleList(people)
//        val peopleRepo = (activity?.application as StartApp).getPeopleRepo()
//        peopleRepo.getAllPeople().observe(this, Observer {
//            peopleList -> populatePeopleList(peopleList!!)
//        })
//    }

}