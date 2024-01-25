package com.paulinoeme.charactersrickmorty.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.paulinoeme.charactersrickmorty.data.model.CharacterModel
import com.paulinoeme.charactersrickmorty.data.model.Result
import com.paulinoeme.charactersrickmorty.domain.GetAllCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val getCharacter: GetAllCharactersUseCase
):ViewModel() {
    val characterModel = MutableLiveData<List<Result>>()
    private var result: List<Result> = emptyList()

    fun onCreate(){
        viewModelScope.launch {
            result = getCharacter("character")
            result.let {
                if (!result.isNullOrEmpty())
                    characterModel.postValue(it)
            }
        }
    }

    fun getCharactersPage(url: String){
        viewModelScope.launch {
            result = getCharacter(url)
            result.let {
                if (!result.isNullOrEmpty())
                    characterModel.postValue(it)
            }
        }
    }
}