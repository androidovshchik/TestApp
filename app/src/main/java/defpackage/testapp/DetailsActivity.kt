package defpackage.testapp

import android.os.Bundle
import coil.api.load
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val cover = intent.getParcelableExtra<Cover>("cover")!!
        tv_title.text = cover.title
        iv_image.load(cover.image)
        tv_author.text = cover.author
        tv_desc.text = cover.description
    }
}