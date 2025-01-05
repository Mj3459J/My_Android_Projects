package com.example.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

private const val Ntab = 3

class MyAdapter (fragmentmanager: FragmentManager, lifecycle: Lifecycle):
    FragmentStateAdapter(fragmentmanager,lifecycle) {
    override fun getItemCount(): Int {
        return Ntab
    }

    override fun createFragment(position: Int): Fragment {
        when(position){
            0-> return Chats()
            1-> return Calls()
            2-> return Status()
        }
        return Chats()
    }


}