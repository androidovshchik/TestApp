package defpackage.testapp

import android.app.Application
import coil.Coil
import coil.ImageLoader

class MainApp : Application() {

    override fun onCreate() {
        super.onCreate()
        Coil.setImageLoader(
            ImageLoader.Builder(applicationContext)
                .availableMemoryPercentage(0.5)
                .bitmapPoolPercentage(0.5)
                .okHttpClient(okHttpClient)
                .build()
        )
    }
}