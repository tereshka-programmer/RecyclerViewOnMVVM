package com.example.rcview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rcview.databinding.ActivityMainBinding
import com.example.rcview.model.User
import com.example.rcview.model.UsersListener
import com.example.rcview.model.UsersService
import com.example.rcview.screens.UserDetailsFragment
import com.example.rcview.screens.UsersListFragment

class MainActivity : AppCompatActivity(), Navigator {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: UsersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                add(R.id.fragmentContainer, UsersListFragment())
            }
        }
    }

    override fun showDetails(user: User) {
        supportFragmentManager.commit {
            addToBackStack(null)
            replace(R.id.fragmentContainer, UserDetailsFragment.newInstance(user.id))
        }
    }

    override fun goBack() {
        onBackPressed()
    }

    override fun toast(messageRes: Int) {
        Toast.makeText(this, messageRes, Toast.LENGTH_SHORT).show()
    }

}