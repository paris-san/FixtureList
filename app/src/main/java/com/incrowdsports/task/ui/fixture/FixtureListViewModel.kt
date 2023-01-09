package com.incrowdsports.task.ui.fixture

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.incrowdsports.task.data.FixtureService
import com.incrowdsports.task.data.models.Fixture
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class FixtureListViewModel(private val service: FixtureService) : ViewModel() {

    val fixtureList = MutableSharedFlow<List<Fixture>>()

    fun loadData(compId: Int, season: Int, size: Int) {
        viewModelScope.launch(Dispatchers.Main) {
            val data = service.getFixtureList(compId = compId, season = season, size = size).data
            fixtureList.emit(data)
        }
    }

}