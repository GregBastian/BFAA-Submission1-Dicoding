package com.example.githubapp_submission_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var rvUsers: RecyclerView
    private var listMain: ArrayList<GithubUser> = arrayListOf()
    private var title = "Github Social"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvUsers = findViewById(R.id.rv_users)
        rvUsers.setHasFixedSize(true)

        listMain.addAll(getDataFromStringResource())
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvUsers.layoutManager = LinearLayoutManager(this)
        val listAdapter = ListAdapter(listMain)
        rvUsers.adapter = ScaleInAnimationAdapter(listAdapter).apply{
            setDuration(350)
            setFirstOnly(false)
        }
        listAdapter.setOnItemClickCallback(object : ListAdapter.OnItemClickCallback {
            override fun onItemClicked(data: GithubUser) {
                showSelectedUserDetail(data)
            }
        })

    }

    private fun getDataFromStringResource(): ArrayList<GithubUser>{
        val githubUserList = arrayListOf<GithubUser>()
        val usernamesData = resources.getStringArray(R.array.username)
        val namesData = resources.getStringArray(R.array.name)
        val locationsData = resources.getStringArray(R.array.location)
        val repositoriesData = resources.getStringArray(R.array.repository)
        val companiesData = resources.getStringArray(R.array.company)
        val followersData = resources.getStringArray(R.array.followers)
        val followingData = resources.getStringArray(R.array.following)
        val avatarsData = resources.obtainTypedArray(R.array.avatar)
        for (index in usernamesData.indices) {
            val githubUser = GithubUser()
            githubUser.username = usernamesData[index]
            githubUser.name = namesData[index]
            githubUser.shortLocation = getMainLocationForUser(locationsData[index])
            githubUser.longLocation = locationsData[index]
            githubUser.company = companiesData[index]
            githubUser.repository = repositoriesData[index]
            githubUser.company = companiesData[index]
            githubUser.followers = followersData[index]
            githubUser.following = followingData[index]
            githubUser.avatar = avatarsData.getResourceId(index,-1)

            githubUserList.add(githubUser)
        }
        return githubUserList
    }

    private fun showSelectedUserDetail(selectedUser: GithubUser){
        // Ada error yang sebelumnya objek tidak dapat muncul saat dipanggil ke intent
        // coba cek getDataFromStringResource, kemungkinan atribut belum dinisialisasi
//        Toast.makeText(this, "Kamu memilih " + currentUser.location, Toast.LENGTH_SHORT).show()

        val objectIntent = GithubUser(
            username = selectedUser.username,
            name = selectedUser.name,
            longLocation  = selectedUser.longLocation,
            repository = selectedUser.repository,
            company = selectedUser.company,
            followers = selectedUser.followers,
            following = selectedUser.following,
            avatar = selectedUser.avatar
        )

        val moveWithObjectIntent = Intent(this@MainActivity, GithubUserDetail::class.java)
        moveWithObjectIntent.putExtra(GithubUserDetail.EXTRA_USER, objectIntent)
        startActivity(moveWithObjectIntent)
    }

    private fun getMainLocationForUser(fullUserLocation: String): String {
        return fullUserLocation.split(",".toRegex()).first()
    }

}
