package com.paulinoeme.charactersrickmorty.data.model

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharacterProvider @Inject constructor() {
    var character: List<Result> = emptyList()
}