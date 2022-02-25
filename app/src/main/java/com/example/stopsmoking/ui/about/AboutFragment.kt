package com.example.stopsmoking.ui.about

import android.annotation.SuppressLint
import android.icu.text.SimpleDateFormat
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.example.stopsmoking.R
import com.example.stopsmoking.ui.info.InformationFragment
import com.example.stopsmoking.ui.shered.SharedViewModel
import com.example.stopsmoking.ui.user.User
import kotlinx.android.synthetic.main.fragment_about.*
import kotlinx.android.synthetic.main.fragment_about.view.*
import java.util.*


class AboutFragment : Fragment(R.layout.fragment_about) {
    private val sharedViewModel: SharedViewModel by activityViewModels()
var count = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initButtonBack()
        initButtonNext()
    }

    private fun initButtonBack() {
        back_arrow.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }
    }

    private fun initButtonNext() {
        button_next.setOnClickListener {
            checkFilds()
            if (edit_name.text.isNullOrEmpty() || edit_price_pack.text.isNullOrEmpty() || edit_age.text.isNullOrEmpty() || edit_text_count_of_sigar.text.isNullOrEmpty() || edit_text_date.text.isNullOrEmpty()) {
                Toast.makeText(
                    requireActivity(),
                    "Необходимо заполнить все поля",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                creteUser()
                requireActivity().supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.container, InformationFragment())
                    .addToBackStack(null)
                    .commitAllowingStateLoss()
            }
        }
    }

    private fun checkFilds()  {
        val name = edit_name.text.toString()
        val pricePack = edit_price_pack.text.toString()
        val age = edit_age.text.toString()
        val countOfSigar = edit_text_count_of_sigar.text.toString()
        val date = edit_text_date.text.toString()


        if (name.isNullOrEmpty()) {
            container_edit_name.isErrorEnabled = true
            container_edit_name.error = "Ты забыл свое имя ублюдок"
        } else {
            container_edit_name.isErrorEnabled = false
        }

        if (pricePack.isNullOrEmpty()) {
            container_edit_price_pack.isErrorEnabled = true
            container_edit_price_pack.error = "Укажите цену за пачку"
        } else {
            container_edit_price_pack.isErrorEnabled = false
        }

        if (age.isNullOrEmpty()) {
            container_edit_age.isErrorEnabled = true
            container_edit_age.error = "Укажите свой возраст"
        } else {
            container_edit_age.isErrorEnabled = false
        }


        if (date.isNullOrEmpty()) {
            container_edit_text_date.isErrorEnabled = true
            container_edit_text_date.error = "Укажите количество дней"
        } else {
            container_edit_text_date.isErrorEnabled = false
        }

        if (countOfSigar.isNullOrEmpty()) {
            container_edit_text_count_of_sigar.isErrorEnabled = true
            container_edit_text_count_of_sigar.error = "Укажите количество сигарет"
        } else {
            container_edit_text_count_of_sigar.isErrorEnabled = false
        }

    }


    private fun creteUser() {
        val name: String = edit_name.text.toString()
        val packPrice: Int = edit_price_pack.text.toString().toInt()
        val age: Int = edit_price_pack.text.toString().toInt()
        val countPackInDay: Int = edit_text_count_of_sigar.text.toString().toInt()
        val data: Int = edit_text_date.text.toString().toInt()
        val user = User(name, packPrice, age, countPackInDay, data)
        sharedViewModel.createUser(user)
    }
}