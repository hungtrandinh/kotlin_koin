package com.example.mvvm_coroutines_koin

import android.app.Application
import com.example.mvvm_coroutines_koin.di.networkModule
import com.example.mvvm_coroutines_koin.di.viewmodelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext
import org.koin.core.context.startKoin

class MyApp : Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@MyApp)
            modules(networkModule)
            modules(viewmodelModule)
        }

    }
}