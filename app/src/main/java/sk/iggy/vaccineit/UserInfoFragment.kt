package sk.iggy.vaccineit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import sk.iggy.vaccineit.databinding.FragmentUserInfoBinding
import sk.iggy.vaccineit.model.UserViewModel

class UserInfoFragment : Fragment() {
    private lateinit var binding: FragmentUserInfoBinding
    private val sharedViewModel: UserViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserInfoBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            viewModel = sharedViewModel
            userInfoFragment = this@UserInfoFragment
            lifecycleOwner = viewLifecycleOwner
        }
    }
}