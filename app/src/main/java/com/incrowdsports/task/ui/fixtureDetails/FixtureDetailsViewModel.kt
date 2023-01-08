package com.incrowdsports.task.ui.fixtureDetails

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.incrowdsports.task.data.FixtureDetailsService
import com.incrowdsports.task.data.models.FixtureDetails
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FixtureDetailsViewModel(private val service: FixtureDetailsService) : ViewModel() {

    val fixtureDetails = MutableLiveData<FixtureDetails>()

    fun loadDetails(feedMatchId: Long) {
        viewModelScope.launch(Dispatchers.Main) {
            val data = service.getFixtureDetails(feedMatchId).data
            fixtureDetails.value = data
        }
    }

}