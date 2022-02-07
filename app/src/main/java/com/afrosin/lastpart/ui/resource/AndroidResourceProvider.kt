package com.afrosin.lastpart.ui.resource

import android.content.Context
import com.afrosin.lastpart.mvp.resource.ResourceProvider

class AndroidResourceProvider(private val context: Context) : ResourceProvider {

    override fun getAppContext(): Context = context
}