package com.example.latihan9.data.data_model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
class People (
    var name: String = "",
    var meat_at: String = "",
    var contact: String = "",
    var email: String = "",
    var facebook: String = "",
    var twiter: String ="",
   @PrimaryKey(autoGenerate = true) var id:  Int = 0
)