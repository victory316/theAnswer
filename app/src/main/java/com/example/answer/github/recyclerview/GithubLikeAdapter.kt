package com.example.answer.github.recyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.answer.R
import com.example.answer.github.GithubActivity
import com.example.answer.github.room.GithubData
import com.example.answer.ui.room.ConferenceData
import kotlinx.android.synthetic.main.conference_item.view.*
import java.text.DateFormat
import java.text.SimpleDateFormat


class GithubLikeAdapter(val contactItemClick: (GithubData) -> Unit, val contactItemLongClick: (GithubData) -> Unit)
    : RecyclerView.Adapter<GithubLikeAdapter.ViewHolder>() {
    private var contacts: List<GithubData> = listOf()
    private val githubRepos: ArrayList<GithubData> = ArrayList()
    private lateinit var view: GithubActivity

    override fun onCreateViewHolder(parent: ViewGroup, i: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.github_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
//        viewHolder.nameTv.text = githubRepos[position].name

        viewHolder.bind(contacts[position])
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val nameTv = itemView.findViewById<TextView>(R.id.user_name)
        private val profileImage = itemView.findViewById<ImageView>(R.id.avatar_image)

        fun bind(githubData: GithubData) {

            Log.d("recyclerViewTest", "name : ${githubData.name}")
            nameTv.text = githubData.name

//            Glide.with(view.applicationContext).load(githubData.avatar_url).into(profileImage)

//
//            nameTv.text = githubData.name
//            numberTv.text = githubData.
//
//            itemView.setOnClickListener {
//                contactItemClick(githubData)
//            }
//
//            itemView.setOnLongClickListener {
//                contactItemLongClick(githubData)
//                true
//            }
        }
    }

    fun setView(view: GithubActivity) {
        this.view = view
    }

    fun update(githubRepos: ArrayList<GithubData>) {
        for (indices in githubRepos) {
            Log.d("updateTest","updating with retrofit : $indices")
        }

        this.githubRepos.clear()
        this.githubRepos.addAll(githubRepos)
        notifyDataSetChanged()
    }

    fun setContacts(contacts: List<GithubData>) {
        this.contacts = contacts
        notifyDataSetChanged()
    }
}