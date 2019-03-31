package com.example.latihan9.data.data_net

import com.example.latihan9.data.data_model.People

class PeopleListInfo {
    companion object {
        var peopleList = initPeopleList()
        /**
         * add Dummy data
         */
        private  fun initPeopleList() : MutableList<People>{
            var po_peoples = mutableListOf<People>()
            po_peoples.add(People(
                "audy",
                "Bekasi",
                "0855955551220",
                "afiaryaudy@yahoo.com",
                "fb.me/clarabel",
                "ga ada",
                1
            ))
            return po_peoples
        }

    }
}