package com.example.stopsmoking.ui.advice

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.stopsmoking.R
import kotlinx.android.synthetic.main.fragment_advice.*

class AdviceFragment : Fragment(R.layout.fragment_advice) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        text_view_back.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

    }
}