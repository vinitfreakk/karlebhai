
package com.example.karlebhai.ui.Fragments
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.karlebhai.R
import com.example.karlebhai.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)


        binding.btnAddNotes.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_homeFragment_to_createNotesFragment)  //"This is the view that was clicked, help me navigate based on it!"

            //for above code simple explanation is below.

            /*Imagine you have a toy car (the Fragment) with a special button on top of it (the button in the layout file). The car represents the Fragment, and the button represents the view that was clicked.

When you click the button on the toy car, the car needs to navigate to a different place. Here's how it works:

The car (Fragment) knows that the button is clicked because it triggers a click event.

The car needs to communicate with its navigation controller (brain) to navigate to a different place.

To do this, the car uses the Navigation.findNavController() command. It's like the car saying, "Hey, navigation controller, I need your help to navigate!"

The car passes the clicked view (the button) as an argument to findNavController(). It's like the car showing the button to the navigation controller and saying, "This is the view that was clicked, help me navigate based on it!"

The findNavController() command helps the car locate and communicate with the navigation controller associated with the car. The navigation controller understands that the button was clicked and knows how to handle the navigation request.

Once the car (Fragment) has found its navigation controller, it tells the navigation controller, "Hey, I want to navigate from the 'homeFragment' to the 'createNotesFragment'." This is done using the navigate() method of the navigation controller.

The navigation controller receives the navigation instruction and guides the car (Fragment) to the 'createNotesFragment'.

So, in simple terms, when you click the button, the Fragment (car) uses Navigation.findNavController() to locate and communicate with its navigation controller (brain). It passes the clicked view (button) to the navigation controller to indicate which view triggered the click. The navigation controller then navigates the Fragment to the desired destination ('createNotesFragment') based on the navigation instruction.*/


            //or the above code can also be wwritten as
            // findNavController().navigate(R.id.action_homeFragment_to_createNotesFragment)    //


        }








        return binding.root
    }


}