package defpackage.testapp

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()

val serverApi: ServerApi = Retrofit.Builder()
    .client(okHttpClient)
    .baseUrl("https://pivl.github.io/")
    .addConverterFactory(
        GsonConverterFactory.create(
            GsonBuilder()
                .setLenient()
                .excludeFieldsWithoutExposeAnnotation()
                .create()
        )
    )
    .build()
    .create(ServerApi::class.java)