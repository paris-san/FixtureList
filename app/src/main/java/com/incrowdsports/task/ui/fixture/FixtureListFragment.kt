package com.incrowdsports.task.ui.fixture

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.incrowdsports.task.R
import com.incrowdsports.task.data.models.Fixture
import com.incrowdsports.task.databinding.FixtureListFragmentBinding
import com.incrowdsports.task.ui.ViewModelFactories
import com.incrowdsports.task.ui.fixtureDetails.FixtureDetailsFragment
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach


class FixtureListFragment : Fragment(R.layout.fixture_list_fragment) {

    private val binding by lazy { FixtureListFragmentBinding.bind(requireView()) }
    private val viewModel: FixtureListViewModel by viewModels { ViewModelFactories.FixtureListViewModelFactory }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val compId = 8
        val season = 2021

        binding.swipeRefreshLayout.setOnRefreshListener {
            viewModel.loadData(compId = compId, season = season)
        }

        val adapter = FixtureListAdapter()
        binding.recyclerView.adapter = adapter

        viewModel.fixtureList
            .flowWithLifecycle(viewLifecycleOwner.lifecycle)
            .onEach { renderFixtureList(fixtureList = it, adapter = adapter) }
            .launchIn(viewLifecycleOwner.lifecycleScope)

        viewModel.loadData(compId = compId, season = season)
    }

    private fun renderFixtureList(fixtureList: List<Fixture>, adapter: FixtureListAdapter) {
        binding.swipeRefreshLayout.isRefreshing = false
        val itemList = fixtureList.map {
            FixtureListAdapter.FixtureItem(
                fixture = it,
                onClick = {
                    parentFragmentManager.commit {
                        add(
                            R.id.fragmentContainerView,
                            FixtureDetailsFragment.newInstance(it.feedMatchId)
                        )
                        addToBackStack(this@FixtureListFragment.toString())
                    }
                },
            )
        }
        adapter.submitList(itemList)
    }

    companion object {
        fun newInstance() = FixtureListFragment()
    }

}