package defpackage.testapp

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import java.lang.ref.WeakReference

abstract class BaseHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    abstract fun onBindItem(position: Int, item: T)
}

@Suppress("MemberVisibilityCanBePrivate")
abstract class BaseAdapter<T> : RecyclerView.Adapter<BaseHolder<T>> {

    val items = mutableListOf<T>()

    protected var reference: WeakReference<Listener<T>>? = null

    @Suppress("unused")
    constructor()

    constructor(listener: Listener<T>) {
        setListener(listener)
    }

    fun setListener(listener: Listener<T>) {
        reference?.clear()
        reference = WeakReference(listener)
    }

    override fun onBindViewHolder(holder: BaseHolder<T>, position: Int) {
        holder.onBindItem(position, items[position])
    }

    override fun getItemCount() = items.size

    interface Listener<T> {

        fun onItemClick(position: Int, item: T)
    }
}