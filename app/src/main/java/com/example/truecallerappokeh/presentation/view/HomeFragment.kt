package com.example.truecallerappokeh.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.truecallerappokeh.data.model.Resource
import com.example.truecallerappokeh.databinding.FragmentFirstBinding
import com.example.truecallerappokeh.presentation.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservables()
        initClickListener()
    }


    private fun initObservables() {
        mainViewModel.viewListData.observe(viewLifecycleOwner, { resource ->
            when (resource) {
                is Resource.Loading -> {
                    binding.taskAValue.text = resource.messages
                    binding.taskBValue.text = resource.messages
                    binding.taskCValue.text = resource.messages
                }

                is Resource.Error -> {
                    binding.taskAValue.text = resource.error?.localizedMessage
                    binding.taskBValue.text = resource.error?.localizedMessage
                    binding.taskCValue.text = resource.error?.localizedMessage
                }

                is Resource.Success -> {
                    binding.taskAValue.text = resource.displayData.firstData
                    binding.taskBValue.text = resource.displayData.secondData.toString()
                    binding.taskCValue.text = resource.displayData.thirdData.toString()
                }

            }
        })
    }

    private fun initClickListener() {
        binding.fetchData.setOnClickListener {
            mainViewModel.callTask()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}