package com.afrosin.lastpart.utils

import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

fun getDate(year: Int, month: Int, date: Int, hrs: Int, min: Int): Date {
    val cal = Calendar.getInstance()
    cal[Calendar.YEAR] = year
    cal[Calendar.MONTH] = month
    cal[Calendar.DAY_OF_MONTH] = date
    cal[Calendar.HOUR_OF_DAY] = hrs
    cal[Calendar.MINUTE] = min
    return cal.time
}

fun dateDiff(startDate: Date, endDate: Date): Long {
    return endDate.time - startDate.time
}

fun Date.toStringFormat(patternDate: String = "dd.MM.yyyy HH:mm:ss"): String =
    SimpleDateFormat(patternDate, Locale.getDefault()).format(this)

fun currentTime(): Date = Calendar.getInstance().time

fun Context.openInApp(appName: String, packageName: String?) {

    if (isAppInstalled(this, packageName!!)) {
        if (isAppEnabled(
                this,
                packageName
            )
        ) {
            this.startActivity(
                this.packageManager.getLaunchIntentForPackage(
                    packageName
                )
            )
        } else {
            Toast.makeText(this, "$appName app is not enabled.", Toast.LENGTH_SHORT)
                .show()
        }
    } else {
        Toast.makeText(
            this,
            "$appName app is not installed.", Toast.LENGTH_SHORT
        ).show()
    }
}

private fun isAppInstalled(context: Context, packageName: String): Boolean {
    val pm = context.packageManager
    try {
        pm.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES)
        return true
    } catch (ignored: PackageManager.NameNotFoundException) {
    }
    return false
}

private fun isAppEnabled(context: Context, packageName: String): Boolean {
    var appStatus = false
    try {
        val ai: ApplicationInfo = context.getPackageManager().getApplicationInfo(packageName, 0)
        if (ai != null) {
            appStatus = ai.enabled
        }
    } catch (e: PackageManager.NameNotFoundException) {
        e.printStackTrace()
    }
    return appStatus
}