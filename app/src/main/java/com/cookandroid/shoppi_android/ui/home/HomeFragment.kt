package com.cookandroid.shoppi_android.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.cookandroid.shoppi_android.*
import com.cookandroid.shoppi_android.databinding.FragmentHomeBinding
import com.cookandroid.shoppi_android.ui.common.ViewModelFactory
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModels { ViewModelFactory(requireContext()) }
    private lateinit var binding : FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = viewLifecycleOwner

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


        setToolbar()
        setTopBanners()
    }

    private fun setToolbar() {
        viewModel.title.observe(viewLifecycleOwner, { title ->
            binding.title = title
        })
    }

    private fun setTopBanners() {
        with(binding.viewpagerHomeBanner) {
            this.adapter = HomeBannerAdapter().apply {
                viewModel.topBanners.observe(viewLifecycleOwner, { banners ->
                    submitList(banners)
                })
            }

            val pageWidth = resources.getDimension(R.dimen.viewpager_item_width)
            val pageMargin = resources.getDimension(R.dimen.viewpager_item_margin)

            val screenWidth = resources.displayMetrics.widthPixels
            val offset = screenWidth - pageWidth - pageMargin

            this.offscreenPageLimit = 3
            this.setPageTransformer { page, position ->
                page.translationX = position * -offset
            }

            TabLayoutMediator(binding.viewpagerHomeBannerIndicator, this) { tab, position ->

            }.attach()
        }
    }
}