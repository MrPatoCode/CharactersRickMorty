package com.paulinoeme.charactersrickmorty.data.network

import com.paulinoeme.charactersrickmorty.data.model.CharacterModel
import com.paulinoeme.charactersrickmorty.data.model.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class CharacterApiService @Inject constructor(
    private val api: CharactersApiClient
) {
    suspend fun getCharacters(url: String): List<Result> {
        return withContext(Dispatchers.IO) {
            val response: Response<CharacterModel> = api.getCharacters(url)
            response.body()?.results?: emptyList()

        }
    }
}