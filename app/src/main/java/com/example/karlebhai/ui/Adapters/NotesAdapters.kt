package com.example.karlebhai.ui.Adapters

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.karlebhai.Models.Notes
import com.example.karlebhai.R
import com.example.karlebhai.databinding.ItemNotesBinding
import com.example.karlebhai.ui.Fragments.HomeFragmentDirections

class NotesAdapters(val requireContext: Context,val notesList: List<Notes>):RecyclerView.Adapter<NotesAdapters.notesVieHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): notesVieHolder {
       return notesVieHolder(ItemNotesBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
      return notesList.size
    }

    override fun onBindViewHolder(holder: notesVieHolder, position: Int) {
        val data = notesList[position]
      holder.binding.notesTitle.text = notesList[position].title
        holder.binding.notesDate.text = notesList[position].date
        holder.binding.notesSubtitle.text = notesList[position].subTitile
        when(notesList[position].priority){
            "1"->{
                holder.binding.notesPriority.setBackgroundResource(R.drawable.green_dot)
            }
            "2"->{
                holder.binding.notesPriority.setBackgroundResource(R.drawable.yellow_dot)
            }
            "3"->{
                holder.binding.notesPriority.setBackgroundResource(R.drawable.red_dot)
            }
        }

        holder.binding.root.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToEditFragment(data)
            Navigation.findNavController(it).navigate(action)

        }
    }

    inner class notesVieHolder(val binding: ItemNotesBinding): RecyclerView.ViewHolder(binding.root)


}