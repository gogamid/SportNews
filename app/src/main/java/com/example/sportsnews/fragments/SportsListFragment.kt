package com.example.sportsnews.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.slidingpanelayout.widget.SlidingPaneLayout
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
          binding.slidingPaneLayout.openPane()
        }
      }
      setHasFixedSize(true)
    }
    val slidingPaneLayout = binding.slidingPaneLayout
    slidingPaneLayout.lockMode = SlidingPaneLayout.LOCK_MODE_LOCKED
    // Connect the SlidingPaneLayout to the system back button.
    requireActivity().onBackPressedDispatcher.addCallback(
      viewLifecycleOwner,
      SportsListOnBackPressedCallback(slidingPaneLayout)
    )
  }

  class SportsListOnBackPressedCallback(
    private val slidingPaneLayout: SlidingPaneLayout
  ) : OnBackPressedCallback(slidingPaneLayout.isSlideable && slidingPaneLayout.isOpen),
    SlidingPaneLayout.PanelSlideListener {
    init {
      slidingPaneLayout.addPanelSlideListener(this)
    }

    override fun handleOnBackPressed() {
      slidingPaneLayout.closePane()
    }

    override fun onPanelSlide(panel: View, slideOffset: Float) {
    }

    override fun onPanelOpened(panel: View) {
      isEnabled = true
    }

    override fun onPanelClosed(panel: View) {
      isEnabled = false
    }
  }
}