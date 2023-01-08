package com.incrowdsports.task.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.incrowdsports.task.data.FixtureDetailsService
import com.incrowdsports.task.data.FixtureService
import com.incrowdsports.task.data.RetrofitClient
import com.incrowdsports.task.ui.fixture.FixtureListViewModel
import com.incrowdsports.task.ui.fixtureDetails.FixtureDetailsViewModel

class ViewModelFactories {
    companion object {

        val FixtureListViewModelFactory: ViewModelProvider.Factory =
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    val service: FixtureService = run {
                        RetrofitClient.getFixtureService()
                    }
                    return FixtureListViewModel(service = service) as T
                }
            }

        val FixtureDetailsViewModelFactory: ViewModelProvider.Factory =
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    val service: FixtureDetailsService = run {
                        RetrofitClient.getFixtureDetailsService()
                    }
                    return FixtureDetailsViewModel(service = service) as T
                }
            }
    }
}