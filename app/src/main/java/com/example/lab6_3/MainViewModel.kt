package com.example.lab6_3

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.URL

class MainViewModel: ViewModel() {
    val bitmapData = MutableLiveData<Bitmap>()

    fun loadImageFromNet() {
        viewModelScope.launch(Dispatchers.IO) {
            val url = URL("https://cdnuploads.aa.com.tr/uploads/Contents/2019/10/24/thumbs_b_c_fb8263ce4f9f43ebdc7634b0d1eb0a08.jpg?v=115427")
            val stream = url.openConnection().getInputStream()
            stream.use {
                val bitmap = BitmapFactory.decodeStream(stream)
                bitmapData.postValue(bitmap)
            }
        }
    }
}