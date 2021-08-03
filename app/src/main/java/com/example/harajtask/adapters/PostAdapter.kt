package com.example.harajtask.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.harajtask.R
import com.example.harajtask.databinding.PostItemLayoutBinding
import com.example.model.Post

class PostAdapter(val posts: List<Post>): RecyclerView.Adapter<PostAdapter.Holder>() {
    private lateinit var context: Context

    class Holder(itemView: View) :RecyclerView.ViewHolder(itemView) {
        private val binding = PostItemLayoutBinding.bind(itemView)
        val username = binding.personName
        val thumbImage = binding.thumbImage
        val title = binding.title
        val time = binding.timeTv
        val comment = binding.commentTv
        val location = binding.locationName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        context = parent.context
        val layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater.inflate(R.layout.post_item_layout, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val post = posts.get(position)
        holder.username.text = post.username
        holder.title.text = post.title
        holder.time.text = context.getString(R.string.post_time)
        holder.comment.text = post.commentCount
        holder.location.text = context.getString(R.string.post_location)

        val url = post.thumbURL
        Glide.with(context)
            .load(url)
            .centerCrop()
            .apply(RequestOptions.bitmapTransform(RoundedCorners(14)))
            .into(holder.thumbImage)
    }

    override fun getItemCount(): Int {
        return posts.size
    }
}