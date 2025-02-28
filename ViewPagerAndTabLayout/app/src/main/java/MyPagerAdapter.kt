import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class MyPagerAdapter(fm:FragmentManager,lc:Lifecycle)
    :FragmentStateAdapter(fm,lc) {

    // creating fragment list so that getItemCount can return no of fragments.
    var fragmentList:ArrayList<Fragment> = ArrayList()
    // now creating method to add fragment in fragmentList.
    fun addFragmentToList(fragment:Fragment){
        fragmentList.add(fragment)
    }

    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList.get(position)
    }
}