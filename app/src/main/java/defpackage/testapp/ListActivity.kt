package defpackage.testapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import kotlinx.android.synthetic.main.activity_list.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.anko.startActivity
import retrofit2.await
import java.text.SimpleDateFormat
import java.util.*

class ListActivity : BaseActivity(), BaseAdapter.Listener<Cover> {

    private val adapter = CoversAdapter(this)

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        rv_covers.adapter = adapter
        rv_covers.addItemDecoration(
            DividerItemDecoration(
                applicationContext,
                DividerItemDecoration.VERTICAL
            ).apply {
                setDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.divider)!!)
            }
        )
        launch {
            var time = 1000L
            while (true) {
                try {
                    val covers = serverApi.getCovers().await()
                    adapter.items.clear()
                    adapter.items.addAll(covers)
                    adapter.notifyDataSetChanged()
                    tv_total.text =
                        "Всего - ${covers.size}. Последнее обновление ${dateFormatter.format(System.currentTimeMillis())}"
                    break
                } catch (e: Throwable) {
                    e.printStackTrace()
                    delay(time)
                    time = (time * 2).coerceAtMost(10_000L)
                }
            }
        }
    }

    override fun onItemClick(position: Int, item: Cover) {
        startActivity<DetailsActivity>("cover" to item)
    }

    companion object {

        private val dateFormatter = SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH)
    }
}