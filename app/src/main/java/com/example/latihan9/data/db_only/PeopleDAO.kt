package com.example.latihan9.data.db_only

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import android.view.autofill.AutofillId
import com.example.latihan9.data.data_model.People

@Dao
interface PeopleDAO {
//    query select
    @Query("select * from people order by id desc")
    fun getAll():LiveData<List<People>>

    //Query Inser
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(people: People)
    //Query Delete
    @Query("delete from people")
    fun deleteALl()

    //Query select
    @Query("select * from people where id = :id")
    fun find(id: Int):People
}