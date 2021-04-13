package com.thangadurai.squashappstask.ui.main

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.thangadurai.squashappstask.R
import com.thangadurai.squashappstask.adapter.ReelAdapter
import com.thangadurai.squashappstask.databinding.ActivityMainBinding
import com.thangadurai.squashappstask.mockData.MockData
import com.thangadurai.squashappstask.ui.base.BaseActivity

class MainActivity : BaseActivity(), View.OnClickListener {

    lateinit var binding: ActivityMainBinding
    var viewModel = MainViewModel()
    var isFollow = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setContentView(binding.root)
        binding.mainViewModel = viewModel
        binding.listener = this

        init()
        initRecyclerview()
        invalidateOptionsMenu()

    }

    private fun init() {
        binding.ivProfile.setImageDrawable(
            ContextCompat.getDrawable(
                this,
                R.drawable.tony_stark
            )
        )
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = ""
        val colorDrawable = ColorDrawable(Color.parseColor("#000000"))
        supportActionBar?.setBackgroundDrawable(colorDrawable)
    }

    private fun initRecyclerview() {
        val adapter = ReelAdapter(this, MockData.listOfReels())
        binding.rvReels.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    override fun onClick(v: View) {
        when (v) {
            binding.btnFollow -> {
                isFollow = if (isFollow) {
                    viewModel.followOrUnFollow.set(getString(R.string.un_follow))
                    false
                } else {
                    viewModel.followOrUnFollow.set(getString(R.string.follow))
                    true
                }
            }
            binding.btnShare -> {
                showMessage("Share Clicked..")
            }
        }
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            R.id.menu -> {
                val popup = showPopup(findViewById(R.id.menu), R.menu.popup_menu)
                popup.setOnMenuItemClickListener { menuItem ->
                    when (menuItem.itemId) {
                        R.id.share -> showMessage("Share Clicked..")
                        R.id.report -> showMessage("Report Clicked..")
                    }
                    true
                }
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}