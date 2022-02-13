package com.cookandroid.shoppi_android

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.gson.Gson
import org.json.JSONObject

class HomeFragment:Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val button = view.findViewById<Button>(R.id.btn_enter_product_detail)
//        button.setOnClickListener {
//            //네비게이션 컴포넌트 사용 전
////            val transaction = parentFragmentManager.beginTransaction()
////            transaction.add(R.id.container_main,ProductDetailFragment())
////            transaction.commit()
//
//            //네비게이션 컴포넌트 사용
//            findNavController().navigate(R.id.action_home_to_product_detail)
//        }

        val tvTitle=view.findViewById<TextView>(R.id.tv_fragment_home_title)
        val ivTitle=view.findViewById<ImageView>(R.id.iv_fragment_home_title)
        val viewpager = view.findViewById<ViewPager2>(R.id.viewpager_home_banner)
        val viewpagerIndicator = view.findViewById<TabLayout>(R.id.viewpager_home_banner_indicator)


        val assetLoader = AssetLoader()
        val homeJsonString = assetLoader.getJsonString(requireContext(),"home.json")
        Log.d("homeData",homeJsonString ?: "")

        if (!homeJsonString.isNullOrEmpty()){
            val gson = Gson()
            val homeData = gson.fromJson(homeJsonString,HomeData::class.java)


            tvTitle.text=homeData.title.text

            GlideApp.with(this)
                .load(homeData.title.iconUrl)
                .into(ivTitle)

            viewpager.adapter = HomeBannerAdapter().apply {
                submitList(homeData.topBanners)
            }

            val pageWidth = resources.getDimension(R.dimen.viewpager_item_width)
            val pageMargin = resources.getDimension(R.dimen.viewpager_item_margin)

            val screenWidth = resources.displayMetrics.widthPixels
            val offset = screenWidth - pageWidth - pageMargin

            viewpager.offscreenPageLimit = 3
            viewpager.setPageTransformer { page, position ->
                page.translationX = position * -offset
            }

            TabLayoutMediator(viewpagerIndicator,viewpager) { tab, position ->

            }.attach()


//            val topBanners = jsonObject.getJSONArray("top_banners")
//            val firstBanner = topBanners.getJSONObject(0)
//            val label = firstBanner.getString("label")
//            val productDetail = firstBanner.getJSONObject("product_detail")
//            val price = productDetail.getInt("price")
//
//            Log.d("title","text=$text, iconUrl=$iconUrl")
//            Log.d("firstBanner","label=$label, price=$price")
        }

    }
}