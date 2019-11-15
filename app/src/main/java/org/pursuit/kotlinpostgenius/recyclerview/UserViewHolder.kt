package org.pursuit.kotlinpostgenius.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_itemviews.view.*

class UserViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    // Holds the TextView that will add each animal to
    val userid = view.userID
    val userEmail = view.userEmail
    val userFirstName = view.userFirstName
    val userLastName = view.userLastName

}