package com.example.quotegenerator.Presentation.NewsScreens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.quotegenerator.R


class NewsInfoFragmentLayout : Fragment(R.layout.fragment_news_info_layout) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageView = view.findViewById<ImageView>(R.id.titleImageNewsActivity)
        val NewsHeading: TextView =view.findViewById(R.id.TvheadingNewsActivity)
        val NewsBody: TextView =view.findViewById(R.id.TvbodyNewsActivity)
        var heading:String?=""
        var image:Int=-1
        var body:String?=""
        val arguments = arguments
        if(arguments!=null){
            heading = arguments.getString("heading")
            image= arguments.getInt("image")
            body = arguments.getString("body")
        }

        NewsHeading.text = heading
        imageView.setImageResource(image)
        NewsBody.text = body
    }




}