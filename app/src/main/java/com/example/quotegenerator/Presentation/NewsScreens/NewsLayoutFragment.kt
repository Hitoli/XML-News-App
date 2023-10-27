package com.example.quotegenerator.Presentation.NewsScreens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quotegenerator.Presentation.Utils.Myadapter
import com.example.quotegenerator.Presentation.Utils.NewsInfo
import com.example.quotegenerator.R


class NewsLayoutFragment : Fragment(R.layout.fragment_news_layout) {

    private lateinit var adapter: Myadapter
    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<NewsInfo>
    lateinit var imageId: Array<Int>
    lateinit var heading: Array<String>
    lateinit var newsbody: Array<String>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageId = arrayOf(
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d
        )

        heading = arrayOf(
            "Parliament in disguise, Are they read for the truth?",
            "Fundamentals of Cities are suffering",
            "New Budget Just Came, How does it impact you?",
            "Captilism in Rise, Democarcy is the New Flaw",
            "Parliament in disguise, Are they read for the truth?",
            "Fundamentals of Cities are suffering",
            "New Budget Just Came, How does it impact you?",
            "Captilism in Rise, Democarcy is the New Flaw",
            "Parliament in disguise, Are they read for the truth?",
            "Fundamentals of Cities are suffering",
            "New Budget Just Came, How does it impact you?",
            "Captilism in Rise, Democarcy is the New Flaw",
            "Parliament in disguise, Are they read for the truth?",
            "Fundamentals of Cities are suffering",
            "New Budget Just Came, How does it impact you?",
            "Captilism in Rise, Democarcy is the New Flaw"
        )

        newsbody = arrayOf(
            getString(R.string.news_a),
            getString(R.string.news_b),
            getString(R.string.news_c),
            getString(R.string.news_d),
            getString(R.string.news_e),
            getString(R.string.news_f),
            getString(R.string.news_g),
            getString(R.string.news_h),
            getString(R.string.news_i),
            getString(R.string.news_j),
            getString(R.string.news_i),
            getString(R.string.news_j),
            getString(R.string.news_a),
            getString(R.string.news_b),
            getString(R.string.news_c),
            getString(R.string.news_d)
        )

        val bundle = Bundle()



        newRecyclerView = view.findViewById(R.id.NewsRecyler)
        newRecyclerView.layoutManager = LinearLayoutManager(context)
        newRecyclerView.setHasFixedSize(true)
        adapter = Myadapter(getItemData())
        adapter.onItemSetClickListener(object : Myadapter.onItemClickListener {
            override fun onItemClick(position: Int) {
                bundle.putString("heading",newArrayList[position].titleHeadline)
                bundle.putString("body",newsbody[position])
                bundle.putInt("image",newArrayList[position].titleImage)

                val destinationFragment = NewsInfoFragmentLayout()
                destinationFragment.arguments=bundle
                val transaction = requireActivity().supportFragmentManager.beginTransaction()
                transaction.replace(R.id.fragmentMainBox, destinationFragment)
                transaction.addToBackStack(null)
                transaction.commit()
            }

        })
        newRecyclerView.adapter = adapter


        //getItemData()
    }

    private fun getItemData(): ArrayList<NewsInfo> {
        newArrayList = arrayListOf()

        for (i in imageId.indices) {
            val newsInfo = NewsInfo(imageId[i], heading[i])
            newArrayList.add(newsInfo)
        }

        return newArrayList

    }

}