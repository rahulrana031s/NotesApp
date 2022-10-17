package com.example.notesapp.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.cheezycode.notesample.models.UserRequest
import com.cheezycode.notesample.models.UserResponse
import com.example.notesapp.api.UserApi
import com.example.notesapp.utils.Constants.TAG
import com.example.notesapp.utils.NetworkResult
import org.json.JSONObject
import retrofit2.Response
import javax.inject.Inject

class UserRepo @Inject constructor(private val userApi: UserApi) {

    private val _userResponseLivedata = MutableLiveData<NetworkResult<UserResponse>>()
    val userLiveData : LiveData<NetworkResult<UserResponse>>
    get() = _userResponseLivedata

    suspend fun registerUser(userRequest: UserRequest){
        _userResponseLivedata.postValue(NetworkResult.Loading())
        val response = userApi.signUp(userRequest)

        handleResponse(response)
        Log.d(TAG,response.body().toString())
    }

    private fun handleResponse(response: Response<UserResponse>) {
        if (response.isSuccessful && response.body() != null) {
            _userResponseLivedata.postValue(NetworkResult.Success(response.body()!!))

        } else if (response.errorBody() != null) {
            val errorObj = JSONObject(response.errorBody()!!.charStream().readText())
            _userResponseLivedata.postValue(NetworkResult.Error(errorObj.getString("message")))

        } else {
            _userResponseLivedata.postValue(NetworkResult.Error("Something Went Wrong"))

        }
    }

    suspend fun loginUser(userRequest: UserRequest){
        val response = userApi.signIn(userRequest)
        handleResponse(response)
        Log.d(TAG,response.body().toString())

    }
}
