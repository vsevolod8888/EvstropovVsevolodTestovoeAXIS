package com.example.vrgsoft_test_yevstropov_vsevolod.dagger
import com.example.evstropovvsevolodtestovoeaxis.fragments.NotesFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RepozitoryModule::class, ViewModelsModule::class]) //
interface Component {
    fun inject(notesFragment: NotesFragment)

}