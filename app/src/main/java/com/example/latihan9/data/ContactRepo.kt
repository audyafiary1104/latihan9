package com.example.latihan9.data

import android.app.Application
import android.arch.lifecycle.LiveData
import com.example.latihan9.data.data_model.People
import com.example.latihan9.data.data_net.PeopleListInfo
import com.example.latihan9.data.db_only.PeopleDAO
import com.example.latihan9.data.db_only.PeopleDb

class ContactRepo(application: Application) {
    private val peopleDao : PeopleDAO
    init {
        val peopleDatabase = PeopleDb.getInstance(application)
        peopleDao = peopleDatabase.peopleDao()
    }
    fun  getAllPeople() : LiveData<List<People>>{
//        val allpeople = PeopleListInfo.peopleList
//        return  allpeople.reversed()
        return peopleDao.getAll()
    }
    fun insertPeople(people: People){
//        PeopleListInfo.peopleList.add(people)
        peopleDao.insert(people)
    }
    fun findPeople(id : Int):People?{
//        for (people in PeopleListInfo.peopleList){
//            if (people.id == id){
//                return  people
//            }
//        }
        return peopleDao.find(id)
    }
}