package com.example.stopsmoking.ui.info

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.activityViewModels
import com.example.stopsmoking.R
import com.example.stopsmoking.ui.advice.AdviceFragment
import com.example.stopsmoking.ui.shered.SharedViewModel
import kotlinx.android.synthetic.main.fragment_info.*
import java.util.*

class InformationFragment : Fragment(R.layout.fragment_info) {
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdviceButton()

        initInformAboutUser()
    }

    private fun initInformAboutUser() {
        val user = sharedViewModel.getUser()
        val date = user.value?.data.toString()

        val manyEconomy =
            user.value?.packPrice.toString().toInt() * user.value?.countPackInDay.toString()
                .toInt() * user.value?.data.toString().toInt()

        count_of_the_days.text = "$date дней"
        count_of_cigarettes_text.text = "${
            user.value?.countPackInDay.toString().toInt() * user.value?.data.toString().toInt()
        } шт"
        count.text = "$manyEconomy рублей"
    }

    private fun initAdviceButton() {
        advice_text.setOnClickListener {
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, AdviceFragment())
                .addToBackStack(null)
                .commitAllowingStateLoss()
        }
    }

}