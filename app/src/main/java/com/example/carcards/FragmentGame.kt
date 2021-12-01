package com.example.carcards

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carcards.databinding.FragmentGameBinding


class FragmentGame : Fragment() {


    data class Question(
        val text: String,
        val answers: List<String>
    )

    private val questions: MutableList<Question> = mutableListOf(
        Question(
            text = "Porsche",
            answers = listOf("Ferrari", "Maserati", "Alfa Romeo", "Lancia")
        )
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    lateinit var currentQuestion: Question
    lateinit var answers: MutableList<String>
    private var questionIndex = 0
    private val numQuestions = Math.min((questions.size + 1) / 2, 3)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentGameBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_game, container, false
        )

        binding.submitButton.setOnClickListener{
            view: View ->
            val checkedId = binding.questionRadioGroup.checkedRadioButtonId
            if (-1 != checkedId){
                var answerIndex = 0
                when (checkedId){
                    binding.secondAnswerRadioButton.id -> answerIndex = 1
                    binding.thirdAnswerRadioButton.id -> answerIndex = 2
                    binding.fourthAnswerRadioButton.id -> answerIndex = 3
                }
                if (answers[answerIndex] == currentQuestion.answers[0]){
                    questionIndex++
                    if (questionIndex < numQuestions){
                        currentQuestion = questions[questionIndex]
                        setQuestion()
                        binding.invalidateAll()
                    } else{
                        view.findNavController().navigate(
                            FragmentGameDirections.actionFragmentGameToFragmentGameWon()
                        )
                    }
                } else {
                    view.findNavController().navigate(FragmentGameDirections.actionFragmentGameToFragmentGameLost())
                }
            }
        }

        return binding.root
    }

    private fun setQuestion() {
        currentQuestion = questions[questionIndex]
        // randomize the answers into a copy of the array
        answers = currentQuestion.answers.toMutableList()
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            FragmentGame().apply {
                arguments = Bundle().apply {

                }
            }
    }

    /*val manager = GridLayoutManager(activity, 3)
    manager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
        override fun getSpanSize(position: Int): Int {
            return when (position) {
                0 -> 3
                else -> 1
            }
        }

    }*/
}