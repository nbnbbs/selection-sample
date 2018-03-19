package com.sample.ar442.selection

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.view.ActionMode
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.RecyclerView
import android.view.DragEvent
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.selection.StorageStrategy
import com.sample.ar442.selection.models.Word
import com.sample.ar442.selection.words.WordAdapter
import com.sample.ar442.selection.words.WordKeyProvider
import com.sample.ar442.selection.words.WordLookup


class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private var actionMode: ActionMode? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)

        val items = IntRange(0, 100).map { Word(it, it.toString()) }
        val adapter = WordAdapter(items)

        recyclerView.adapter = adapter
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        val tracker = SelectionTracker
                .Builder<Word>(
                        "someId",
                        recyclerView,
                        WordKeyProvider(items),
                        WordLookup(recyclerView),
                        StorageStrategy.createParcelableStorage(Word::class.java)
                )
                .withOnDragInitiatedListener { it.action == DragEvent.ACTION_DRAG_STARTED }
                .build()

        adapter.tracker = tracker

        tracker.addObserver(object : SelectionTracker.SelectionObserver<Any>() {
            override fun onSelectionChanged() {
                super.onSelectionChanged()
                if (tracker.hasSelection() && actionMode == null) {
                    actionMode = startSupportActionMode(ActionModeController(this@MainActivity, tracker))
                    setSelectedTitle(tracker.selection.size())
                } else if (!tracker.hasSelection()) {
                    actionMode?.finish()
                    actionMode = null
                } else {
                    setSelectedTitle(tracker.selection.size())
                }
            }
        })
    }

    private fun setSelectedTitle(selected: Int) {
        actionMode?.title = "Selected: $selected"
    }

}
