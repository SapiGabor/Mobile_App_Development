package com.example.carcards

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.carcards.databinding.FragmentGameStartBinding


class FragmentGameStart : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding: FragmentGameStartBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_game_start, container, false
        )
        binding.button.setOnClickListener {view ->
            view.findNavController().navigate(FragmentGameStartDirections.actionFragmentGameStartToFragmentGame())
        }
        return binding.root
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            FragmentGameStart().apply {
                arguments = Bundle().apply {

                }
            }
    }
}