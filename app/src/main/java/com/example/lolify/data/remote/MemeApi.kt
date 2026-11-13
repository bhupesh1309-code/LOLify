package com.example.lolify.data.remote

import com.example.lolify.data.Meme
import retrofit2.http.GET

interface MemeApi{
    @GET("gimme")
    suspend fun getRandomMeme(): Meme
}