package com.paulinoeme.charactersrickmorty.domain

import com.paulinoeme.charactersrickmorty.data.CharactersRepository
import com.paulinoeme.charactersrickmorty.data.model.CharacterModel
import com.paulinoeme.charactersrickmorty.data.model.Result
import javax.inject.Inject

class GetAllCharactersUseCase @Inject constructor(
    private val repository: CharactersRepository
) {
    suspend operator fun invoke(url: String): List<Result>
    {
        return repository.getCharacters(url)
    }
}