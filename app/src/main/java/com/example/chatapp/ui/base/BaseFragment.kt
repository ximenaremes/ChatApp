package com.example.chatapp.ui.base

import androidx.fragment.app.Fragment
import com.example.chatapp.utils.SimpleMessageDialog

open class BaseFragment : Fragment() {

    private val simpleMessageDialog: SimpleMessageDialog by lazy {
        return@lazy SimpleMessageDialog(
            requireContext()
        )
    }

    protected fun showError(errorMessage: String) {
        simpleMessageDialog.showError(errorMessage)
    }

    protected fun showInfo(infoMessage: String, onPositiveClicked: (() -> Unit)? = null) {
        simpleMessageDialog.showInfo(infoMessage, onPositiveClicked)
    }
}