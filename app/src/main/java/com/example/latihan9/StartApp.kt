package com.example.latihan9

import android.app.Application
import com.example.latihan9.data.ContactRepo

class StartApp : Application() {
    fun getPeopleRepo() = ContactRepo(this)
}