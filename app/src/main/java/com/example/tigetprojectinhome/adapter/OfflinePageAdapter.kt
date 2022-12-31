package com.example.tigetprojectinhome.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tigetprojectinhome.R
import com.example.tigetprojectinhome.db.entities.MovieEntity
import com.example.tigetprojectinhome.db.entities.OfflinePageMovieEntity
import com.example.tigetprojectinhome.model.MovieModel

open class OfflinePageAdapter : RecyclerView.Adapter<OfflinePageAdapter.MyViewHolder>() {

    var listDataUser: List<OfflinePageMovieEntity>? = null

    fun setListData(listDataUser: List<OfflinePageMovieEntity>?) {
        this.listDataUser = listDataUser
    }

    // click listener
    var onDataUserClickListener: ((OfflinePageMovieEntity) -> Unit)? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OfflinePageAdapter.MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.offline_item, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: OfflinePageAdapter.MyViewHolder, position: Int) {
        holder.bind(listDataUser?.get(position)!!)
    }

    override fun getItemCount(): Int {
        if (listDataUser == null) return 0
        return listDataUser?.size!!
    }

    class MyViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {
        private val realName = view.findViewById<TextView>(R.id.tv_offline_real_name)
        private val name = view.findViewById<TextView>(R.id.tv_offline_text)
        private val team = view.findViewById<TextView>(R.id.tv_offline_team)
        private val image = view.findViewById<ImageView>(R.id.iv_offline_image)


        fun bind(dataUser: OfflinePageMovieEntity) {
            name.text = dataUser.id.toString()
            realName.text = dataUser.realName
            team.text = dataUser.team

//            Glide.with(image)
//                .load(dataUser.)
//                .into(userAvatarImageView)
        }
    }
}