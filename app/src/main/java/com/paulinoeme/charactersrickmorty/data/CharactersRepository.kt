package com.paulinoeme.charactersrickmorty.data

import com.paulinoeme.charactersrickmorty.data.model.CharacterModel
import com.paulinoeme.charactersrickmorty.data.model.CharacterProvider
import com.paulinoeme.charactersrickmorty.data.model.Result
import com.paulinoeme.charactersrickmorty.data.network.CharacterApiService
import javax.inject.Inject

class CharactersRepository @Inject constructor(
    private val api: CharacterApiService,
    private val charactersProvider:CharacterProvider
){
    suspend fun getCharacters(url:String): List<Result>{
        val response: List<Result> = api.getCharacters(url)
        charactersProvider.character = response
        return response
    }
}