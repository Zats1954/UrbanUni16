package ru.zatsoft.phoneshop1

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class MyDialog : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity())
        return builder
            .setTitle("Ремонт телефона")
            .setMessage("Ремонтитуем ?")
            .setPositiveButton("Да") { _, _ ->
                Toast.makeText(activity, "телефон отремонтирован", Toast.LENGTH_LONG)
                    .show()
            }
            .setNegativeButton("Отмена") { _, _ ->
                Toast.makeText(activity, "не нуждаетесь в ремонте", Toast.LENGTH_LONG)
                    .show()
            }
            .create()
    }
}