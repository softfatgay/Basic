package com.example.basic.provider

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.net.Uri
import com.example.basic.Constants.LAUNCH_LOG
import com.example.basic.utils.Logu
import java.text.SimpleDateFormat

class APMContentProvider : ContentProvider() {
    override fun onCreate(): Boolean {
        Logu.d("${LAUNCH_LOG}launch.click", "${System.currentTimeMillis()}")
        return true
    }

    override fun query(
        uri: Uri,
        projection: Array<out String>?,
        selection: String?,
        selectionArgs: Array<out String>?,
        sortOrder: String?
    ): Cursor? {
        return null
    }

    override fun getType(uri: Uri): String? {
        return null
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        return null
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?): Int {
        return 0
    }

    override fun update(
        uri: Uri,
        values: ContentValues?,
        selection: String?,
        selectionArgs: Array<out String>?
    ): Int {
        return 0
    }

    private fun getDateTime(s: Long): String? {
        return SimpleDateFormat("yyyy-MM-DD-hh-mm-ss").format(s)
    }
}
