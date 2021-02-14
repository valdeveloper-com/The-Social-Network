package com.disizaniknem.thesocialnetwork.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.disizaniknem.thesocialnetwork.R
import com.disizaniknem.thesocialnetwork.ui.auth.AuthActivity
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment)
                as NavHostFragment

        bottomNavigationView.apply {
            background = null
            menu.getItem(2).isEnabled = false
            setupWithNavController(navHostFragment.findNavController())
            setOnNavigationItemReselectedListener { Unit }
        }

        fabNewPost.setOnClickListener {
            navHostFragment.findNavController().navigate(
                R.id.globalActionToCreatePostFragment
            )
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.miLogout -> {
                FirebaseAuth.getInstance().signOut()
                Intent(this, AuthActivity::class.java).also {
                    startActivity(it)
                    finish()
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
}