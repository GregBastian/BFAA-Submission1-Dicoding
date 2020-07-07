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

    private lateinit var  userAvatar: ImageView
    private lateinit var userRepos: TextView
    private lateinit var userFollowers:TextView
    private lateinit var userFollowing:TextView
    private lateinit var userUsername: TextView

    private lateinit var userFullname: TextView
    private lateinit var userCompany: TextView
    private lateinit var userLocation: TextView

    private lateinit var btnFollow: Button
    private lateinit var btnMessage: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_github_user_detail)

        val currentUser = intent.getParcelableExtra(EXTRA_USER) as GithubUser

        userAvatar = findViewById(R.id.user_detail_avatar)
        userRepos = findViewById(R.id.user_detail_repos)
        userFollowers = findViewById(R.id.user_detail_followers)
        userFollowing = findViewById(R.id.user_detail_following)
        userUsername = findViewById(R.id.user_detail_username)
        userFullname = findViewById(R.id.user_detail_fullname)
        userCompany = findViewById(R.id.user_detail_company)
        userLocation = findViewById(R.id.user_detail_location)

        userAvatar.setImageResource(currentUser.avatar)
        userRepos.text = currentUser.repository
        userFollowers.text = currentUser.followers
        userFollowing.text = currentUser.following
        userUsername.text = currentUser.username

        userFullname.text = currentUser.name
        userCompany.text = currentUser.company
        userLocation.text = currentUser.longLocation

        btnFollow = findViewById(R.id.btn_user_detail_follow)
        btnMessage = findViewById(R.id.btn_user_detail_message)

        btnFollow.setOnClickListener(this)
        btnMessage.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_user_detail_follow -> Toast.makeText(baseContext, "'Following' Feature In Progress!", Toast.LENGTH_SHORT).show()
            R.id.btn_user_detail_message -> Toast.makeText(baseContext, "'Messaging' Feature In Progress!", Toast.LENGTH_SHORT).show()
        }
    }
}
