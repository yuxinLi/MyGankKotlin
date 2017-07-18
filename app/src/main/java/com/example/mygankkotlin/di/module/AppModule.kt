package com.example.mygankkotlin.di.module

import android.content.Context
import dagger.Module
import dagger.Provides

/**
 * 描    述：
 * 作    者：liyx@13322.com
 * 时    间：2017/7/18
 */

@Module
class AppModule(private val context: Context) {
    @Provides fun provideContext() = context
}