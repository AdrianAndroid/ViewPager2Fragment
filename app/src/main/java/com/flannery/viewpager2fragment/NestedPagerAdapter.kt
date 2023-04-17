//package com.flannery.viewpager2fragment
//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.fragment.app.Fragment
//import androidx.fragment.app.FragmentActivity
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import androidx.viewpager2.adapter.FragmentStateAdapter
//import androidx.viewpager2.widget.ViewPager2
//
//class NestedPagerAdapter(private val outerViewPager: ViewPager2) :
//    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
//    private val innerAdapters = mutableListOf<RecyclerView.Adapter<RecyclerView.ViewHolder>>()
//
//    fun addAdapter(adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>) {
//        innerAdapters.add(adapter)
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//        return object : RecyclerView.ViewHolder(View(parent.context)) {}
//    }
//
//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        val adapter = innerAdapters[position]
//        if (adapter is FragmentStateAdapter) {
//            val fragment = adapter.createFragment(position)
//            fragment.view?.let { itemView ->
//                itemView.parent?.let { parent ->
//                    (parent as ViewGroup).removeView(itemView)
//                    outerViewPager.addView(itemView)
//                }
//            }
//        } else if (adapter is RecyclerView.Adapter<*>) {
//            val recyclerView = RecyclerView(holder.itemView.context)
//            recyclerView.apply {
//                adapter = adapter
//                layoutManager = LinearLayoutManager(context)
//            }
//            outerViewPager.addView(recyclerView)
//        }
//    }
//
//    override fun getItemCount(): Int {
//        return innerAdapters.size
//    }
//
//    override fun getItemViewType(position: Int): Int {
//        return position
//    }
//
//    override fun onViewDetachedFromWindow(holder: RecyclerView.ViewHolder) {
//        super.onViewDetachedFromWindow(holder)
//        outerViewPager.removeView(holder.itemView)
//    }
//}
//
//class OuterPagerAdapter(fragmentActivity: FragmentActivity) :
//    FragmentStateAdapter(fragmentActivity) {
//    private val innerAdapters = mutableListOf<RecyclerView.Adapter<RecyclerView.ViewHolder>>()
//
//    fun addAdapter(adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>) {
//        innerAdapters.add(adapter)
//        notifyDataSetChanged()
//    }
//
//    override fun getItemCount(): Int {
//        return innerAdapters.size
//    }
//
//    override fun createFragment(position: Int): Fragment {
//        return object : Fragment() {
//            override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//                super.onViewCreated(view, savedInstanceState)
//                val viewPager2 = view.findViewById<ViewPager2>(R.id.innerViewPager2)
////                viewPager2.adapter = NestedPagerAdapter(requireParentFragment().viewPager2).apply {
////                    addAdapter(innerAdapters[position])
////                }
//            }
//
//            override fun onCreateView(
//                inflater: LayoutInflater,
//                container: ViewGroup?,
//                savedInstanceState: Bundle?,
//            ): View? {
//                return inflater.inflate(R.layout.fragment_inner_viewpager2, container, false)
//            }
//        }
//    }
//
//    fun test() {
//    }
//}
