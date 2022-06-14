package com.example.sportsnews.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.sportsnews.databinding.FragmentContentBinding
import com.example.sportsnews.model.NewsViewModel

class ContentFragment : Fragment() {
  private val viewModel: NewsViewModel by activityViewModels()
  private lateinit var binding: FragmentContentBinding

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentContentBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    viewModel.imageId.observe(viewLifecycleOwner) { newImageId ->
      binding.imageView.setImageResource(newImageId)
    }

    viewModel.title.observe(viewLifecycleOwner) { newTitle ->
      binding.titleTv.text = newTitle
    }
  }
}