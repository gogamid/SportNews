package com.example.sportsnews.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.sportsnews.databinding.FragmentContentBinding

class ContentFragment : Fragment() {
  private lateinit var binding: FragmentContentBinding

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentContentBinding.inflate(inflater, container, false)
    arguments?.let {
      binding.imageView.setImageResource(it.getInt("imageId"))
      binding.titleTv.text = it.getString("title").toString()
    }
    return binding.root
  }
}