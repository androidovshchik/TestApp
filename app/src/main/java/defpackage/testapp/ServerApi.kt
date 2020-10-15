package defpackage.testapp

import retrofit2.Call
import retrofit2.http.GET

interface ServerApi {

    @GET("/sample_api/covers")
    fun getCovers(): Call<List<Cover>>
}