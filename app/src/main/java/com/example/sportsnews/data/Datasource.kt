package com.example.sportsnews.data

import com.example.sportsnews.R
import com.example.sportsnews.model.News

class Datasource {
  fun loadNews(): List<News> = listOf(
    News(R.drawable.icon_badminton, "Badminton", "Here are some Badminton news"),
    News(R.drawable.icon_baseball, "Baseball", "Here are some Baseball news"),
    News(R.drawable.icon_basketball, "Basketball", "Here are some Basketball news"),
    News(R.drawable.icon_bowling, "Bowling", "Here are some Bowling news"),
    News(R.drawable.icon_cycling, "Cycling", "Here are some Cycling news"),
    News(R.drawable.icon_golf, "Golf", "Here are some Golf news"),
    News(R.drawable.icon_running, "Running", "Here are some Running news"),
    News(R.drawable.icon_soccer, "Soccer", "Here are some Soccer news"),
    News(R.drawable.icon_swimming, "Swimming", "Here are some Swimming news"),
    News(R.drawable.icon_tabletennis, "Table Tennis", "Here are some Table Tennis news"),
    News(R.drawable.icon_tennis, "Tennis", "Here are some Tennis news")
  )
}