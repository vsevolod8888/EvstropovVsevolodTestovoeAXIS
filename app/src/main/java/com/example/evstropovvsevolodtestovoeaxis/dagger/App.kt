package com.example.evstropovvsevolodtestovoeaxis.dagger

import android.app.Application
import com.example.vrgsoft_test_yevstropov_vsevolod.dagger.Component
import com.example.vrgsoft_test_yevstropov_vsevolod.dagger.DaggerComponent
import com.example.vrgsoft_test_yevstropov_vsevolod.dagger.RepozitoryModule

class App : Application() {
    lateinit var ourComponent: Component
    override fun onCreate() {
        super.onCreate()
        ourComponent = DaggerComponent.builder()
            .repozitoryModule(RepozitoryModule(this)) //передаю контекст в конструктор,в большом RepozitoryModule
            .build()
    }
    fun getappComponent(): Component {
        return ourComponent
    }
}