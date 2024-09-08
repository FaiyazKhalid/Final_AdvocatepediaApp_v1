package com.advocatepedia.lite.ui.screens.today_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.advocatepedia.lite.data.database.ViWikiDatabase
import com.advocatepedia.lite.data.repository.DayRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class TodayViewModel(private val repository: DayRepository) : ViewModel() {
    init {
        refreshDataFromRepository()
    }

    val dayData = repository.data
    val dayDataStatus = repository.dataStatus

    fun refreshDataFromRepository() {
        viewModelScope.launch {
            while (true) {
                repository.refreshData()
                delay(10_000) // Delay for 60 seconds (1 minute)
            }
        }
    }


    companion object {
        val Factory = viewModelFactory {
            initializer {
                val applicationContext = this[APPLICATION_KEY]?.applicationContext
                val database = ViWikiDatabase.getInstance(applicationContext = applicationContext!!)
                TodayViewModel(repository = DayRepository(database))
            }
        }
    }
}