package com.flannery.viewpager2fragment

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var blankViewPager2: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val title = view.findViewById<TextView>(R.id.title)
        blankViewPager2 = view.findViewById(R.id.blankViewPager2)
        title.text = getTitle()
        blankViewPager2.adapter = MyPagerAdapter()
        blankViewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL
    }

    private fun getTitle(): String {
        return "$param1 - $param2"
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BlankFragment.
         */
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BlankFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}

class MyPagerAdapter : RecyclerView.Adapter<PagerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.layout_recyclerview, parent, false)
        return PagerViewHolder(item)
    }

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        Log.i("BlankFragment", "position=$position")
        when (position) {
            0 -> Color.RED
            1 -> Color.BLUE
            2 -> Color.GREEN
            3 -> Color.YELLOW
            else -> Color.BLUE
        }.let { color ->
            holder.itemView.setBackgroundColor(color)
        }
    }

    override fun getItemCount(): Int {
        return 4
    }
}

class PagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)