package com.example.karlebhai.ui.Fragments

import android.os.Bundle
import android.text.format.DateFormat
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.karlebhai.Models.Notes
import com.example.karlebhai.R
import com.example.karlebhai.ViewModel.NotesViewModel
import com.example.karlebhai.databinding.FragmentEditBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.Date


class EditFragment : Fragment() {
    val pastNotes by navArgs<EditFragmentArgs>()
    lateinit var binding:FragmentEditBinding
    val viewModel: NotesViewModel by viewModels()
    var priority: String = "1"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentEditBinding.inflate(layoutInflater,container,false)
        binding.editNotes.setText(pastNotes.data.notes)
        binding.editTitle.setText(pastNotes.data.title)
        binding.editSubtitle.setText(pastNotes.data.subTitile)
        when(pastNotes.data.priority){
            "1"->{
                priority = "1"
                binding.pGreen.setImageResource(R.drawable.baseline_check_24)
                binding.pRed.setImageResource(0)
                binding.pYellow.setImageResource(0)
            }
            "2"->{
                priority = "2"
                binding.pYellow.setImageResource(R.drawable.baseline_check_24)
                binding.pGreen.setImageResource(0)
                binding.pRed.setImageResource(0)
            }
            "3"->{
                priority = "3"
                binding.pRed.setImageResource(R.drawable.baseline_check_24)
                binding.pGreen.setImageResource(0)
                binding.pYellow.setImageResource(0)
            }
        }
          //to change the priority
        binding.pGreen.setOnClickListener {
            priority = "1"
            binding.pGreen.setImageResource(R.drawable.baseline_check_24)
            binding.pRed.setImageResource(0)
            binding.pYellow.setImageResource(0)
        }

        binding.pYellow.setOnClickListener {
            priority = "2"
            binding.pYellow.setImageResource(R.drawable.baseline_check_24)
            binding.pGreen.setImageResource(0)
            binding.pRed.setImageResource(0)
        }

        binding.pRed.setOnClickListener {
            priority = "3"
            binding.pRed.setImageResource(R.drawable.baseline_check_24)
            binding.pGreen.setImageResource(0)
            binding.pYellow.setImageResource(0)
        }


        binding.btnEditSaveNotes.setOnClickListener {
            upadteNotes(it)
            Navigation.findNavController(it).navigate(R.id.action_editFragment_to_homeFragment)
        }


        binding.deleteNote.setOnClickListener {
            val bottomSheet:BottomSheetDialog = BottomSheetDialog(requireContext())
            bottomSheet.setContentView(R.layout.delete_dialog_box)
            val cancel = bottomSheet.findViewById<TextView>(R.id.cancel)
            val delete = bottomSheet.findViewById<TextView>(R.id.delete)
            val navigate = Navigation.findNavController(it)

            cancel?.setOnClickListener {
                bottomSheet.dismiss()
            }

            delete?.setOnClickListener {
                GlobalScope.launch {
                    viewModel.deleteNote(pastNotes.data.id!!)
                }

                navigate.navigate(R.id.action_editFragment_to_homeFragment)
                bottomSheet.dismiss()
            }
            bottomSheet.show()

        }
        return binding.root
    }

    private fun upadteNotes(it: View?) {
        val title = binding.editTitle.text.toString()
        val subTitle = binding.editSubtitle.text.toString()
        val notes = binding.editNotes.text.toString()

        val d = Date()
        val s: CharSequence = DateFormat.format("MMMM d, yyyy ", d.time)

        val data = Notes(id = pastNotes.data.id , title, subTitle, notes, s.toString(), priority)

        lifecycleScope.launch{
            viewModel.updateNotes(data)
            Toast.makeText(context, "Note Updated Successfully", Toast.LENGTH_SHORT).show()
        }
    }


}