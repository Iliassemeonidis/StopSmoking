package com.example.stopsmoking.ui.shered

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.stopsmoking.ui.user.User

class SharedViewModel : ViewModel() {

    private var mutableData = MutableLiveData<User>()

    fun createUser(user:User) {
        mutableData.value = user
    }

    fun getUser() : LiveData<User> {
        return mutableData
    }
}