package com.sample.ar442.selection

import android.content.Context
import android.support.v7.view.ActionMode
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.selection.SelectionTracker

class ActionModeController(
        private val context: Context,
        private val tracker: SelectionTracker<*>
) : ActionMode.Callback {

    override fun onCreateActionMode(mode: ActionMode, menu: Menu?): Boolean {
        mode.menuInflater.inflate(R.menu.action_menu, menu)
        return true
    }

    override fun onDestroyActionMode(mode: ActionMode?) {
        tracker.clearSelection()
    }

    override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {
        return true
    }

    override fun onActionItemClicked(mode: ActionMode, item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_clear -> mode.finish().let {
                mode.finish()
                true
            }
            else -> false
        }
    }

}