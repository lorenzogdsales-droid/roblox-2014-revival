package com.gameos.desktop.utils
import android.content.Context
import android.content.SharedPreferences
object GameOSStorage {
    private const val PREFS_NAME = "gameos_prefs"
    private const val KEY_SYSTEM_HOUR = "system_hour"
    private const val KEY_SYSTEM_MINUTE = "system_minute"
    private fun getPreferences(context: Context): SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    fun saveSystemTime(context: Context, hour: Int, minute: Int) { getPreferences(context).edit().apply { putInt(KEY_SYSTEM_HOUR, hour); putInt(KEY_SYSTEM_MINUTE, minute); apply() } }
    fun getSystemTime(context: Context): Pair<Int, Int> { val prefs = getPreferences(context); val hour = prefs.getInt(KEY_SYSTEM_HOUR, 12); val minute = prefs.getInt(KEY_SYSTEM_MINUTE, 0); return Pair(hour, minute) }
}