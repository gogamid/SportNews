package com.example.sportsnews.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.sportsnews.adapter.ItemAdapter
import com.example.sportsnews.data.Datasource
import com.example.sportsnews.databinding.FragmentSportsListBinding


class SportsListFragment : Fragment() {
  private lateinit var binding: FragmentSportsListBinding

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentSportsListBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    val myDataset = Datasource().loadNews()
    binding.recyclerView.apply {
      adapter = ItemAdapter(requireContext(), myDataset)
      setHasFixedSize(true)
    }
  }
}