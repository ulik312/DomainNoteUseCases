package com.sbor.domainnoteusecases.presentation.utils

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.widget.Toast

fun AlertDialog.Builder.buildAndShow(
    positiveButtonAction: (() -> Unit)? = null,
    negativeButtonAction: (() -> Unit)? = null,
): AlertDialog {
    val alertDialog = this.create()

    if (positiveButtonAction != null) {
        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Yes") { _, _ ->
            positiveButtonAction.invoke()
        }
    }

    if (negativeButtonAction != null) {
        alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "No") { _, _ ->
            negativeButtonAction.invoke()
        }
    }
    alertDialog.show()
    return alertDialog
}

fun Context.showToast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}