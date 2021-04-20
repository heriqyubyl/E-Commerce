package com.example.warteg_sedap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {


    // Initialise the DrawerLayout, NavigationView and ToggleBar
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var actionBarToggle: ActionBarDrawerToggle
    private lateinit var navDrawerView: NavigationView
    private lateinit var Rv_Resource: RecyclerView
    private var list: ArrayList<ResourceModel> = arrayListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val arrayItem = ArrayList<ResourceModel>()
        arrayItem.add(ResourceModel("Paket Hemat",R.drawable.adidas))
        arrayItem.add(ResourceModel("Soto",R.drawable.adidas))
        arrayItem.add(ResourceModel("Mie Goreng",R.drawable.adidas))
        arrayItem.add(ResourceModel("Nasi Goreng",R.drawable.adidas))
        arrayItem.add(ResourceModel("Minuman",R.drawable.adidas))

        var myAdapter = ResourceAdapter(arrayItem, this)

        Rv_Resource.layoutManager = LinearLayoutManager(this)
        Rv_Resource.adapter = myAdapter


        // Call findViewById on the DrawerLayout
        drawerLayout = findViewById(R.id.activity_main)

        // Pass the ActionBarToggle action into the drawerListener
        actionBarToggle = ActionBarDrawerToggle(this, drawerLayout, 0, 0)
        drawerLayout.addDrawerListener(actionBarToggle)

        // Display the hamburger icon to launch the drawer
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // change to the back button when the drawer layout is open
        actionBarToggle.syncState()

        // Call findViewById on the NavigationView
        navDrawerView = findViewById(R.id.navDrawer)
        // Call setNavigationItemSelectedListener on the NavigationView
        navDrawerView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.myProfile -> {
                    Toast.makeText(
                        this, "Go to My Profile", Toast.LENGTH_SHORT
                    ).show()
                    true
                }
                R.id.myWishList -> {
                    Toast.makeText(this, "Go to My Wish List", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.myOrders -> {
                    Toast.makeText(this, "Go to My Orders", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.faq -> {
                    Toast.makeText(this, "Go to FAQ", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.email -> {
                    Toast.makeText(this, "Go to Email", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.call -> {
                    Toast.makeText(this, "Go to Call", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> {
                    false
                }
            }
        }
    }

    //override the onSupportNavigateUp() function to open / close Drawer
    override fun onSupportNavigateUp(): Boolean {
        if (this.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            this.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            this.drawerLayout.openDrawer(GravityCompat.START)
        }
        return true
    }

    //Baris Coding Toolbar mulai dari sini
    //Call inflate toolbar Menu to Main Activity
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }
    //Clicked item toolbar
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if(id == R.id.search){
            Toast.makeText(
                this,
                "Go To Search",
                Toast.LENGTH_SHORT
            ).show()
            return true
        }
        else if(id == R.id.myOrders) {
            Toast.makeText(
                this,
                "Go to My Orders",
                Toast.LENGTH_SHORT
            ).show()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}