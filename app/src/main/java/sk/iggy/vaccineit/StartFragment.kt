package sk.iggy.vaccineit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import sk.iggy.vaccineit.databinding.FragmentStartBinding
import sk.iggy.vaccineit.model.UserViewModel

class StartFragment : Fragment() {
    private lateinit var binding: FragmentStartBinding
    private val sharedViewModel: UserViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStartBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.startFragment = this
    }

    fun goToNextScreen() {
        val id = binding.idInput.text.toString()

        if (id.length == 10) {
            sharedViewModel.setId(id)
            findNavController().navigate(R.id.action_startFragment_to_userFormFragment)
        }
        else {
            binding.idInput.error = "Your Id must have 10 numbers."
        }
    }
}