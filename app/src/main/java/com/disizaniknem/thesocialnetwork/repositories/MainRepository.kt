package com.disizaniknem.thesocialnetwork.repositories

import android.net.Uri
import com.disizaniknem.thesocialnetwork.data.entities.User
import com.disizaniknem.thesocialnetwork.other.Resource

interface MainRepository {

    suspend fun createPost(imageUri: Uri, text: String): Resource<Any>

    suspend fun getUsers(uids: List<String>) : Resource<List<User>>

    suspend fun getUser(uid: String) : Resource<User>

}