package com.disizaniknem.thesocialnetwork.di

import com.disizaniknem.thesocialnetwork.repositories.DefaultMainRepository
import com.disizaniknem.thesocialnetwork.repositories.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
object MainModule {

    @ActivityScoped
    @Provides
    fun provideMainRepository() = DefaultMainRepository() as MainRepository

}