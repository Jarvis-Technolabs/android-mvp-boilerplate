package com.jainamj.myapplication.data.api

import com.jainamj.myapplication.data.api.models.git.Follower
import com.jainamj.myapplication.data.api.models.git.UserInfo
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface GitService {

    @GET("users/{username}")
    fun getUserInfo(@Path("username") userName: String?): Observable<UserInfo>

    @GET("users/{username}/followers")
    fun getUserFollowers(@Path("username") userName: String?): Observable<List<Follower>>

}