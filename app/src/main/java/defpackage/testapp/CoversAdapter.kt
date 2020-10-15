package defpackage.testapp

import android.annotation.SuppressLint
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.item_cover.view.*

class CoversAdapter(listener: Listener<Cover>) : BaseAdapter<Cover>(listener) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.item_cover))
    }

    inner class ViewHolder(itemView: View) : BaseHolder<Cover>(itemView) {

        private val caption: TextView = itemView.tv_caption

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                val item = items[position]
                reference?.get()?.onItemClick(position, item)
            }
        }

        @SuppressLint("SetTextI18n")
        override fun onBindItem(position: Int, item: Cover) {
            caption.text = item.title
        }
    }
}