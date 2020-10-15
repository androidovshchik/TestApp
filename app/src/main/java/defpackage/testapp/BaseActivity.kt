package defpackage.testapp

import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*

@Suppress("MemberVisibilityCanBePrivate")
abstract class BaseActivity : AppCompatActivity(), CoroutineScope {

    protected val job = SupervisorJob()

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        job.cancelChildren()
        super.onDestroy()
    }

    override val coroutineContext = Dispatchers.Main + job + CoroutineExceptionHandler { _, e ->
        e.printStackTrace()
    }
}