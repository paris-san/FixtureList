package com.incrowdsports.task.ui.fixtureDetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.incrowdsports.task.data.models.Player
import com.incrowdsports.task.databinding.PlayerAwayRowLayoutBinding
import com.incrowdsports.task.databinding.PlayerHomeRowLayoutBinding

class FixturePlayersListAdapter(private val mList: List<Player>, private val isHomeTeam: Boolean) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (isHomeTeam) {
            PlayerHomeViewHolder.create(parent)
        } else {
            PlayerAwayViewHolder.create(parent)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (isHomeTeam) {
            (holder as PlayerHomeViewHolder).bind(mList[position])
        } else {
            (holder as PlayerAwayViewHolder).bind(mList[position])
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (isHomeTeam) 1 else 2
    }

    class PlayerHomeViewHolder(private val binding: PlayerHomeRowLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Player) {
            binding.playerName.text = "${item.firstName} ${item.lastName}"
            binding.root.context?.let {
                Glide.with(it)
                    .load(item.playerImageUrl)
                    .into(binding.playerImage)
            }
        }

        companion object {
            fun create(parent: ViewGroup) = PlayerHomeViewHolder(
                PlayerHomeRowLayoutBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }

    class PlayerAwayViewHolder(private val binding: PlayerAwayRowLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Player) {
            binding.playerName.text = "${item.firstName} ${item.lastName}"
            binding.root.context?.let {
                Glide.with(it)
                    .load(item.playerImageUrl)
                    .into(binding.playerImage)
            }
        }

        companion object {
            fun create(parent: ViewGroup) = PlayerAwayViewHolder(
                PlayerAwayRowLayoutBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }

}