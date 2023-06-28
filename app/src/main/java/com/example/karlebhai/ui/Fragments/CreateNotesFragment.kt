package com.example.karlebhai.ui.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.karlebhai.R
import com.example.karlebhai.databinding.FragmentCreateNotesFragmentsBinding


class CreateNotesFragment : Fragment() {
    lateinit var binding:FragmentCreateNotesFragmentsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCreateNotesFragmentsBinding.inflate(layoutInflater,container,false)







        return binding.root
    }


}