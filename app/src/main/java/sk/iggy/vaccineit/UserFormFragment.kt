package sk.iggy.vaccineit

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import sk.iggy.vaccineit.data.daysArray
import sk.iggy.vaccineit.data.monthsArray
import sk.iggy.vaccineit.data.yearsArray
import sk.iggy.vaccineit.databinding.FragmentUserFormBinding

class UserFormFragment : Fragment() {
    private lateinit var binding: FragmentUserFormBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserFormBinding.inflate(inflater, container, false)

        val listOfVaccine = resources.getStringArray(R.array.type_of_vaccines)
        val vaccineArrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, listOfVaccine)
        val daysArrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, daysArray)
        val monthsArrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, monthsArray)
        val yearsArrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, yearsArray)

        /// binding for dropdown list
        binding.vaccinesDropdown.setAdapter(vaccineArrayAdapter)
        binding.dayDropdown.setAdapter(daysArrayAdapter)
        binding.monthDropdown.setAdapter(monthsArrayAdapter)
        binding.yearDropdown.setAdapter(yearsArrayAdapter)

        binding.nextButton.setOnClickListener { goToNextScreen() }

        return binding.root
    }

    private fun goToNextScreen() {
        findNavController().navigate(R.id.action_userFormFragment_to_userInfoFragment)
    }
}