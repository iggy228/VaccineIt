package sk.iggy.vaccineit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import sk.iggy.vaccineit.data.daysArray
import sk.iggy.vaccineit.data.monthsArray
import sk.iggy.vaccineit.data.yearsArray
import sk.iggy.vaccineit.databinding.FragmentUserFormBinding
import sk.iggy.vaccineit.model.UserViewModel

class UserFormFragment : Fragment() {
    private lateinit var binding: FragmentUserFormBinding
    private val sharedViewModel: UserViewModel by activityViewModels()

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

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = sharedViewModel
        binding.userFormFragment = this
    }

    /**
     * return false if inputs are correctly written, otherwise true
     */
    private fun checkInputs(): Boolean {
        var isError = false

        if (binding.inputFirstname.text.isNullOrEmpty()) {
            isError = true
            binding.inputFirstname.error = "Please enter your firstname"
        }

        if (binding.inputLastname.text.isNullOrEmpty()) {
            isError = true
            binding.inputLastname.error = "Please enter your lastname"
        }
        if (binding.inputEmail.text.isNullOrEmpty()) {
            isError = true
            binding.inputEmail.error = "Please enter correct e-mail"
        }
        if (binding.inputPhone.text.isNullOrEmpty()) {
            isError = true
            binding.inputPhone.error = "Please enter your phone number"
        }

        return isError
    }

    fun goToNextScreen() {

        if (checkInputs()) return

        val firstname = binding.inputFirstname.text.toString()
        val lastname = binding.inputLastname.text.toString()
        val email = binding.inputEmail.text.toString()
        val phone = binding.inputPhone.text.toString()

        val day = binding.dayDropdown.text.toString()
        val month = binding.monthDropdown.text.toString()
        val year = binding.yearDropdown.text.toString()

        val vaccineType = binding.vaccinesDropdown.text.toString()

        sharedViewModel.setFullname(firstname, lastname)

        sharedViewModel.setEmail(email)
        sharedViewModel.setPhone(phone)

        sharedViewModel.setBirthday("$day.$month.$year")

        sharedViewModel.setVaccineType(vaccineType)

        findNavController().navigate(R.id.action_userFormFragment_to_userInfoFragment)
    }
}