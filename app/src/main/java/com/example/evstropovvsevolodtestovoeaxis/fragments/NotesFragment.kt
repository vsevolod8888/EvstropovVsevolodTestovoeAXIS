package com.example.evstropovvsevolodtestovoeaxis.fragments

import AdapterNote
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.evstropovvsevolodtestovoeaxis.databinding.FragmentNotesBinding
import android.content.DialogInterface
import android.app.AlertDialog
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.evstropovvsevolodtestovoeaxis.dagger.App
import com.example.evstropovvsevolodtestovoeaxis.database.Note
import javax.inject.Inject

class NotesFragment : Fragment() {
    private var _binding: FragmentNotesBinding? = null
    private val binding get() = _binding!!
    lateinit var adapter: AdapterNote

    @Inject
    lateinit var viewModelProvider: ViewModelProvider.Factory
    private val notesFragmentViewModel: NotesFragmentViewModel by activityViewModels { viewModelProvider }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (requireActivity().application as App).getappComponent().inject(this)
        _binding = FragmentNotesBinding.inflate(inflater, container, false)

        adapter = AdapterNote()
        binding.recycterNotes.layoutManager = LinearLayoutManager(requireContext())
        binding.recycterNotes.adapter = adapter

        notesFragmentViewModel.notelist.observe(viewLifecycleOwner, Observer {

        })
        binding.floatingActionButton.setOnClickListener {
            showNewRouteDialog()
        }
        return binding.root
    }

    fun showNewRouteDialog() {
        val li = LayoutInflater.from(requireContext())
        val dialogView: View =
            li.inflate(com.example.evstropovvsevolodtestovoeaxis.R.layout.alert_dialog, null)
        val alertDialogBuilder: AlertDialog.Builder = AlertDialog.Builder(
            requireContext()
        )
        alertDialogBuilder.setView(dialogView)
        val inputTittle =
            dialogView.findViewById<View>(com.example.evstropovvsevolodtestovoeaxis.R.id.userInputTittle) as TextView
        val inputContent =
            dialogView.findViewById<View>(com.example.evstropovvsevolodtestovoeaxis.R.id.userInputContent) as TextView
        alertDialogBuilder
            .setCancelable(false)
            .setPositiveButton(
                "OK",
                DialogInterface.OnClickListener { dialog, id ->
                    val newNote = Note(
                        id = 0,
                        email = "hh",
                        tittle = inputTittle.text.toString(),
                        content = inputContent.text.toString()
                    )
                    notesFragmentViewModel.insertNote(newNote)
                })
            .setNegativeButton("Cancel",
                DialogInterface.OnClickListener { dialog, id -> dialog.cancel() })

        val alertDialog: AlertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }

//    override fun onDeleteClickK(note: NoteDomain) {
//        notesFragmentViewModel.deleteNote(note.id)
//    }
}