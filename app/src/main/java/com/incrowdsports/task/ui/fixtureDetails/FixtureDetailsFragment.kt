package com.incrowdsports.task.ui.fixtureDetails

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.incrowdsports.task.R
import com.incrowdsports.task.data.models.FixtureDetails
import com.incrowdsports.task.databinding.FragmentFixtureDetailsBinding
import com.incrowdsports.task.ui.ViewModelFactories

class FixtureDetailsFragment : Fragment(R.layout.fragment_fixture_details) {

    private val binding by lazy { FragmentFixtureDetailsBinding.bind(requireView()) }
    private val viewModel: FixtureDetailsViewModel by viewModels { ViewModelFactories.FixtureDetailsViewModelFactory }

    companion object {

        fun newInstance(feedMatchId: Long) = run {
            val newFragment = FixtureDetailsFragment()
            val args = Bundle()
            args.putLong("feedMatchId", feedMatchId)
            newFragment.arguments = args
            newFragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            viewModel.loadDetails(feedMatchId = it.getLong("feedMatchId"))
        }

        viewModel.fixtureDetails.observe(viewLifecycleOwner) { details -> updateUi(details) }
    }

    private fun updateUi(item: FixtureDetails) {
        binding.competition.text = item.competition
        binding.period.text = item.period
        binding.venue.text = item.venue.name
        binding.homeName.text = item.homeTeam.name
        binding.homeScore.text = item.homeTeam.score
        binding.awayName.text = item.awayTeam.name
        binding.awayScore.text = item.awayTeam.score

        context?.let {
            Glide.with(it)
                .load(item.homeTeam.imageUrl)
                .into(binding.homeTeamImage)

            Glide.with(it)
                .load(item.awayTeam.imageUrl)
                .into(binding.awayTeamImage)
        }

        val adapterHomeTeam =
            FixturePlayersListAdapter(mList = item.homeTeam.players, isHomeTeam = true)
        binding.homeTeamPlayers.adapter = adapterHomeTeam

        val adapterAwayTeam =
            FixturePlayersListAdapter(mList = item.awayTeam.players, isHomeTeam = false)
        binding.awayTeamPlayers.adapter = adapterAwayTeam

    }
}