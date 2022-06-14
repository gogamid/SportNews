package com.example.sportsnews.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sportsnews.R

class NewsViewModel : ViewModel() {
  private val _imageId = MutableLiveData<Int>(R.drawable.icon_badminton)
  val imageId: LiveData<Int> = _imageId

  private val _title = MutableLiveData<String>("")
  val title: LiveData<String> = _title

  fun setImageId(imageId: Int) {
    _imageId.value = imageId
  }

  fun setTitle(title: String) {
    _title.value = title
  }
}