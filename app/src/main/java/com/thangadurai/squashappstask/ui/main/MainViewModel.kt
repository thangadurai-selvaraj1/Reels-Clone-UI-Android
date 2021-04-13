package com.thangadurai.squashappstask.ui.main

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {


    var name = ObservableField("Eleanor Pena")
    var userName = ObservableField("@eleanor333")
    var description =
        ObservableField("Reels is an Indian photo and video sharing social networking service.")
    var followers = ObservableField("10K")
    var following = ObservableField("1.1K")
    var views = ObservableField("15.2M")
    var likes = ObservableField("75.2M")
    var totalVideos = ObservableField("125 Videos")
    var totalLikes = ObservableField("1.1K Liked")
    var followOrUnFollow = ObservableField("Follow")


}