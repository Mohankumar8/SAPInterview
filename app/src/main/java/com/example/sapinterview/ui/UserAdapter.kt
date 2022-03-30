package com.example.sapinterview.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sapinterview.R
import com.example.sapinterview.data.entities.User

class UserAdapter(private val userList: List<User>): RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    class UserViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.tvTitle)
        val description: TextView = view.findViewById(R.id.tvDescription)
        val image: ImageView = view.findViewById(R.id.ivAvatar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val item = userList[position]
        holder.title.text = item.name
        holder.description.text = item.description

        Glide
            .with(holder.image.context)
            .load(userList[position].image)
            .placeholder(R.mipmap.ic_launcher)
            .dontAnimate()
            .into(holder.image)

        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, DetailsActivity::class.java)
            intent.putExtra(it.resources.getString(R.string.name), item.name)
            intent.putExtra(it.resources.getString(R.string.description), item.description)
            intent.putExtra(it.resources.getString(R.string.image), item.image)
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}