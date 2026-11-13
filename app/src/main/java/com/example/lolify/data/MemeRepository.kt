package com.example.lolify.data

import com.example.lolify.data.remote.MemeApi

class MemeRepository( private val api: MemeApi) {
    suspend fun getRandomMeme(): Meme {
        return api.getRandomMeme()
    }
}