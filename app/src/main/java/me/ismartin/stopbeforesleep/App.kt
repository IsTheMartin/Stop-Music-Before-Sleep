package me.ismartin.stopbeforesleep

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

/**
 * Created by martin.morales on 05/07/21
 */
@HiltAndroidApp
class App: Application() {

    override fun onCreate() {
        super.onCreate()
        if(BuildConfig.DEBUG)
            Timber.plant(Timber.DebugTree())
        else
            Timber.plant(CrashReportingTree())
    }

    companion object {
        private class CrashReportingTree: Timber.Tree() {
            override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
                if(priority == Log.VERBOSE || priority == Log.DEBUG)
                    return
            }

        }
    }

}