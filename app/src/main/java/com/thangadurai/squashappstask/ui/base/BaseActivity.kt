package com.thangadurai.squashappstask.ui.base

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.ContextThemeWrapper
import androidx.appcompat.widget.PopupMenu
import com.thangadurai.squashappstask.R

open class BaseActivity : AppCompatActivity() {

    fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    fun showPopup(fromView: View, whichMenu: Int): PopupMenu {
        val wrapper: Context = ContextThemeWrapper(this, R.style.MyPopupOtherStyle)
        val popup = PopupMenu(wrapper, fromView)
        try {
            val fields = popup.javaClass.declaredFields
            for (field in fields) {
                if ("mPopup" == field.name) {
                    field.isAccessible = true
                    val menuPopupHelper = field[popup]
                    val classPopupHelper = Class.forName(menuPopupHelper.javaClass.name)
                    val setForceIcons = classPopupHelper.getMethod(
                        "setForceShowIcon",
                        Boolean::class.javaPrimitiveType
                    )
                    setForceIcons.invoke(menuPopupHelper, true)
                    break
                }
            }
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
        popup.menuInflater.inflate(whichMenu, popup.menu)

        popup.show()

        return popup
    }
}