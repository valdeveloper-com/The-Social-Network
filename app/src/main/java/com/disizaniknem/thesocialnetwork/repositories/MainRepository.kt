package com.disizaniknem.thesocialnetwork.repositories

import android.net.Uri
import com.disizaniknem.thesocialnetwork.other.Resource

interface MainRepository {

    suspend fun createPost(imageUri: Uri, text: String): Resource<Any>

}