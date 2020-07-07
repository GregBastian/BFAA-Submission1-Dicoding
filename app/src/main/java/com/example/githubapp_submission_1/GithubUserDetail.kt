package com.example.githubapp_submission_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_github_user_detail.*

class GithubUserDetail : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val EXTRA_USER = "extra_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_github_user_detail)

        val currentUser = intent.getParcelableExtra<GithubUser>(EXTRA_USER) as GithubUser

        user_detail_avatar.setImageResource(currentUser.avatar)
        user_detail_repos.text = currentUser.repository
        user_detail_followers.text = currentUser.followers
        user_detail_following.text = currentUser.following
        user_detail_username.text = currentUser.username
        user_detail_fullname.text = currentUser.name
        user_detail_company.text = currentUser.company
        user_detail_location.text = currentUser.longLocation

        btn_user_detail_follow.setOnClickListener(this)
        btn_user_detail_message.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_user_detail_follow -> Toast.makeText(baseContext, "'Following' Feature In Progress!", Toast.LENGTH_SHORT).show()
            R.id.btn_user_detail_message -> Toast.makeText(baseContext, "'Messaging' Feature In Progress!", Toast.LENGTH_SHORT).show()
        }
    }
}
