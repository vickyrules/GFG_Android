package com.mine.gfgnews.ui.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mine.gfgnews.data.repository.NewsRepository
import com.mine.gfgnews.network.model.Item
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

sealed interface HomeUiState {
    data class Success(val NewsList: List<Item>) : HomeUiState
    data class Error(val message:String) : HomeUiState
    data class Loading(val isLoading:Boolean) : HomeUiState
}


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val newsRepository: NewsRepository
) : ViewModel() {

    var homeUiState: HomeUiState by mutableStateOf(HomeUiState.Loading(false))
        private set

    private val _isRefreshing  =  MutableStateFlow(false)
    val isRefreshing = _isRefreshing.asStateFlow()

    init {
        refresh()
    }


    fun getNewsList() {
        viewModelScope.launch {
            homeUiState = HomeUiState.Loading(true)
            _isRefreshing.value = true
            homeUiState = try {
                HomeUiState.Success(newsRepository.getNewsList())
            } catch (e: IOException) {
                HomeUiState.Error(message = e.toString())
            } catch (e: HttpException) {
                HomeUiState.Error(message = e.toString())
            }
            _isRefreshing.value = false
        }
    }

    fun refresh(){
        getNewsList()
    }
}