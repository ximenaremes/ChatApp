package com.example.chatapp.utils

import android.content.Context
import com.afollestad.materialdialogs.MaterialDialog
import com.example.chatapp.R

class SimpleMessageDialog(
    private val context: Context
) {

    private val errorDialog: MaterialDialog by lazy {
        return@lazy MaterialDialog(windowContext = context)
            .cancelable(true)
            .title(R.string.popup_title_error)
            .positiveButton(R.string.popup_action_ok)
            .cornerRadius(res = R.dimen.general_radius)
    }

    private val infoDialog: MaterialDialog by lazy {
        return@lazy MaterialDialog(windowContext = context)
            .cancelable(true)
            .title(R.string.popup_title_info)
            .positiveButton(R.string.popup_action_ok)
            .cancelOnTouchOutside(false)
            .cornerRadius(res = R.dimen.general_radius)
    }

    fun showError(errorText: String) {
        if (!errorDialog.isShowing) {
            errorDialog.show {
                message(text = errorText)
            }
        }
    }

    fun showInfo(infoMessage: String, onPositiveClicked: (() -> Unit)? = null) {
        if (!infoDialog.isShowing) {
            infoDialog.show {
                message(text = infoMessage)
                positiveButton { onPositiveClicked?.invoke() }
            }
        }
    }

}