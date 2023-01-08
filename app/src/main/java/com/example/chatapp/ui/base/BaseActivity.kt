package com.example.chatapp.ui.base

import androidx.appcompat.app.AppCompatActivity
import com.example.chatapp.utils.SimpleMessageDialog

open class BaseActivity : AppCompatActivity() {

    private val simpleMessageDialog: SimpleMessageDialog by lazy {
        return@lazy SimpleMessageDialog(
            this
        )
    }

    protected fun showError(errorMessage: String) {
        simpleMessageDialog.showError(errorMessage)
    }

    protected fun showInfo(infoMessage: String, onPositiveClicked: (() -> Unit)? = null) {
        simpleMessageDialog.showInfo(infoMessage, onPositiveClicked)
    }
}