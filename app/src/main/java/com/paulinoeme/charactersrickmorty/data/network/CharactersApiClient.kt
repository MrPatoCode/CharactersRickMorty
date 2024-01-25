package com.paulinoeme.charactersrickmorty.data.network

import com.paulinoeme.charactersrickmorty.data.model.CharacterModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface CharactersApiClient {
    @GET
    suspend fun getCharacters(@Url url: String): Response<CharacterModel>
}