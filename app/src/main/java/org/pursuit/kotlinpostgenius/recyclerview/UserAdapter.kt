package org.pursuit.kotlinpostgenius.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.pursuit.kotlinpostgenius.R
import org.pursuit.kotlinpostgenius.model.UserInfo

class UserAdapter(private val items: ArrayList<UserInfo>) : RecyclerView.Adapter<UserViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.activity_itemviews, parent, false))
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder?.userid?.text = items.get(position).toString()
    }

    override fun getItemCount(): Int {
        return items.size
    }

}

