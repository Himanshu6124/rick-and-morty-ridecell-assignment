package com.himanshu.rickandmorty

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.himanshu.rickandmorty.model.CharacterResponse
import kotlinx.coroutines.launch

class CharacterViewModel(private val repository: CharacterRepository) : ViewModel() {

    private val _characters  = MutableLiveData<CharacterResponse>()
    val characters  : MutableLiveData<CharacterResponse> = _characters

    fun getCharacters(page :Int){
        viewModelScope.launch {
            val res = repository.getCharacters(page)
            _characters.postValue(res)
        }
    }

    fun searchCharacters(name :String){
        viewModelScope.launch {
            val res = repository.searchCharacters(name)
            _characters.postValue(res)
        }
    }
}