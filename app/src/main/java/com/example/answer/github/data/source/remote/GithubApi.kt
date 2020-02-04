package com.example.answer.github.data.source.remote

import com.example.answer.github.data.UserList
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubApi {
    @GET("/search/users")
    fun searchUser(@Query("q") users : String) : Observable<UserList>
}