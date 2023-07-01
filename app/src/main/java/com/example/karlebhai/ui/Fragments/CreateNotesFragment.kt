package com.example.karlebhai.ui.Fragments
import android.os.Bundle
import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import com.example.karlebhai.Models.Notes
import com.example.karlebhai.R
import com.example.karlebhai.ViewModel.NotesViewModel
import com.example.karlebhai.databinding.FragmentCreateNotesFragmentsBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.Date


class CreateNotesFragment : Fragment() {

    lateinit var binding: FragmentCreateNotesFragmentsBinding
    var priority: String = "1"
    val viewModel: NotesViewModel by viewModels()  /*by viewModels() delegates the creation of the NotesViewModel instance to the viewModels() function.*/

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding = FragmentCreateNotesFragmentsBinding.inflate(layoutInflater, container, false)

        binding.pGreen.setImageResource(R.drawable.baseline_check_24)


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

        binding.btnSaveNotes.setOnClickListener{
            createNotes(it)
            Navigation.findNavController(it).navigate(R.id.action_createNotesFragment_to_homeFragment)
        }






        return binding.root
    }

    private fun createNotes(it: View?) {
        val title = binding.editTitle.text.toString()
        val subTitle = binding.editSubtitle.text.toString()
        val notes = binding.editNotes.text.toString()

        val d = Date()
        val s: CharSequence = DateFormat.format("MMMM d, yyyy ", d.time)

        val data = Notes(id = null, title, subTitle, notes, s.toString(), priority)

        lifecycleScope.launch{
            viewModel.addNotes(data)
            Toast.makeText(context, "Note Added", Toast.LENGTH_SHORT).show()
        }



    }

}