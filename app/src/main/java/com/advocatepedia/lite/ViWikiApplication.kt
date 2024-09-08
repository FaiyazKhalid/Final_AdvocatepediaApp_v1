package com.advocatepedia.lite

import android.app.Application
import com.advocatepedia.lite.data.database.ViWikiDatabase

class ViWikiApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        ViWikiDatabase.getInstance(this)//initialize database instance
    }
}