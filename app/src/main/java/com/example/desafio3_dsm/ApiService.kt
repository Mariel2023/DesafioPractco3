package com.example.desafio3_dsm

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*



interface ApiService {
    @GET("recursos")
    suspend fun getRecursos(): List<Recurso>

    @GET("recursos/{id}")
    suspend fun getRecursoById(@Path("id") id: String): Recurso

    @POST("recursos")
    suspend fun agregarRecurso(@Body recurso: Recurso): Recurso

    @PUT("recursos/{id}")
    suspend fun modificarRecurso(@Path("id") id: String, @Body recurso: Recurso): Recurso

    @DELETE("recursos/{id}")
    suspend fun eliminarRecurso(@Path("id") id: String): Unit
}

object RetrofitClient {
    private const val BASE_URL = "https://6705b2cf031fd46a8310bed3.mockapi.io/recursoseducativos/"

    val instance: ApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(ApiService::class.java)
    }
}

