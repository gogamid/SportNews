package com.example.sportsnews.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.sportsnews.R
import com.example.sportsnews.adapter.ItemAdapter
import com.example.sportsnews.data.Datasource
import com.example.sportsnews.databinding.FragmentSportsListBinding
import com.example.sportsnews.model.NewsViewModel


class SportsListFragment : Fragment() {
  private val viewModel: NewsViewModel by activityViewModels()
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
      adapter = ItemAdapter(myDataset) {
        viewModel.apply {
          setImageId(it.imageId)
          setTitle(it.title)
          this@SportsListFragment.findNavController()
            .navigate(R.id.action_sportsListFragment_to_contentFragment)
        }
      }
      setHasFixedSize(true)
    }
  }
}