package com.disizaniknem.thesocialnetwork.ui.main.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.disizaniknem.thesocialnetwork.data.pagingsource.FollowPostsPagingSource
import com.disizaniknem.thesocialnetwork.other.Constants.PAGE_SIZE
import com.disizaniknem.thesocialnetwork.repositories.MainRepository
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class HomeViewModel @ViewModelInject constructor(
    private val repository: MainRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Main
) : BasePostViewModel(repository, dispatcher) {

    val pagingFlow = Pager(PagingConfig(PAGE_SIZE)) {
        FollowPostsPagingSource(FirebaseFirestore.getInstance())
    }.flow.cachedIn(viewModelScope)

}