package com.example.sportsnews.data

import com.example.sportsnews.R
import com.example.sportsnews.model.News

class Datasource {
  fun loadNews(): List<News> = listOf(
    News(R.drawable.icon_badminton),
    News(R.drawable.icon_baseball),
    News(R.drawable.icon_basketball),
    News(R.drawable.icon_bowling),
    News(R.drawable.icon_cycling),
    News(R.drawable.icon_golf),
    News(R.drawable.icon_running),
    News(R.drawable.icon_soccer),
    News(R.drawable.icon_swimming),
    News(R.drawable.img_tabletennis),
    News(R.drawable.img_tennis)
  )
}