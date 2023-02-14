package com.example.lovecalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.lovecalculator.databinding.FragmentHistoryBinding
import com.example.lovecalculator.repository.Repository
import com.example.lovecalculator.room.LoveDao
import com.example.lovecalculator.viewmodel.LoveViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HistoryFragment : Fragment() {

    @Inject
    lateinit var  dataBase : LoveDao


    private lateinit var binding: FragmentHistoryBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataBase.getAllAtoZ().observe(viewLifecycleOwner, Observer {
            it.forEach {
                binding.historyTv.append("${it.firstName}\n ${it.secondName} \n ${it.percentage} \n${it.result}\n\n")
            }
        }

        )




    }
}