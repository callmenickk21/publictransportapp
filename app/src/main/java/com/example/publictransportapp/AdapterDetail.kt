package com.example.publictransportapp

import android.content.Context
import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class AdapterDetail(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
     FragmentStateAdapter(fragmentManager, lifecycle){
    override fun getItemCount(): Int {

        return 2
    }

    override fun createFragment(position: Int): Fragment {

        return if(position==0)
            PhotoFragment()
        else
            MapFragment()
    }


}
