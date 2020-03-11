package by.tsetserskaya.carttestcase.ui

import android.view.*
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import by.tsetserskaya.carttestcase.R
import by.tsetserskaya.carttestcase.model.response.CartItemResponse
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

class MyCartRecyclerItemRecyclerViewAdapter(
    private val mValues: List<CartItemResponse>
) : RecyclerView.Adapter<MyCartRecyclerItemRecyclerViewAdapter.ViewHolder>() {

    var listener: ClickViewListener = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.cart_recycler_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]

        holder.apply {
            bind(item)
            itemView.setOnClickListener {
                listener(ProductClickEvent(item.productId?.toInt() ?: 0))
            }
        }
    }

    override fun getItemCount(): Int = mValues.size

    class ViewHolder(private val mView: View) : RecyclerView.ViewHolder(mView) {
        fun bind(item: CartItemResponse) {

            val imageView = mView.findViewById<ImageView>(R.id.img_view)
            val productName = mView.findViewById<TextView>(R.id.product_name)
            val priceTag = mView.findViewById<TextView>(R.id.price_tag)

            productName.text = item.name
            priceTag.text = item.price.toString()

            if (!item.image.isNullOrBlank()) {
                Glide.with(mView.context)
                    .load(item.image)
                    .apply(
                        RequestOptions()
                            .fitCenter()
                            .override(
                                250, 250
                            )
                    )
                    .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                    .skipMemoryCache(true)
                    .into(imageView)
            }

        }
    }

}
