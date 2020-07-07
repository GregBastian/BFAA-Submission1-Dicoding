package com.example.githubapp_submission_1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_row_github_user.view.*
import java.util.*

class ListAdapter(private val listUser: ArrayList<GithubUser>) : RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val displayUsername: TextView = itemView.tv_user_username
        val displayRealName: TextView = itemView.tv_user_realname
        val displayShortLocation: TextView = itemView.tv_user_location_basic
        val displayAvatar: ImageView = itemView.github_user_avatar
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_github_user, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listUser.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, index: Int) {
        val currentUser = listUser[index]
        val avatarWidth = 200
        val avatarHeight = avatarWidth

        Glide.with(holder.itemView.context)
            .load(currentUser.avatar)
            .apply(RequestOptions().override(avatarWidth, avatarHeight))
            .into(holder.displayAvatar)

        holder.displayUsername.text = currentUser.username
        holder.displayRealName.text = currentUser.name
        holder.displayShortLocation.text = currentUser.shortLocation

//        var displayUsername: TextView = itemView.findViewById(R.id.tv_user_username)
//        var displayRealName: TextView = itemView.findViewById(R.id.tv_user_realname)
//        var displayShortLocation: TextView = itemView.findViewById(R.id.tv_user_location_basic)
//        var displayAvatar: ImageView = itemView.findViewById(R.id.github_user_avatar)

        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listUser[holder.adapterPosition]) }

    }
    interface OnItemClickCallback {
        fun onItemClicked(data: GithubUser)
    }
}