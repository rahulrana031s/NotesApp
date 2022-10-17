package com.example.notesapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cheezycode.notesample.models.NoteRequest
import com.cheezycode.notesample.models.UserResponse
import com.example.notesapp.utils.NetworkResult

class ServiceViewModal() : ViewModel(){
    var count = 0



    private var _userResponseLivedata = MutableLiveData<Int>()
    val userLiveData : LiveData<Int>
        get() = _userResponseLivedata


    fun setCount(){
        _userResponseLivedata.value =  count++

    }








}