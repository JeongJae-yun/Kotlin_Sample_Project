package com.example.kotlin_sample.view.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_sample.R
import com.example.kotlin_sample.data.source.image.ImageRepository
import com.example.kotlin_sample.view.main.home.adapter.ImageRecyclerAdapter
import com.example.kotlin_sample.view.main.home.presenter.HomeContract
import com.example.kotlin_sample.view.main.home.presenter.HomePresenter
import kotlinx.android.synthetic.main.activity_recycler_view.*
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), HomeContract.View {

    //Presenter사용을 위해 정의를 하는 것.
    //lazy패턴으로 만들어주고
    //this로 Fragment를 강제로 넘겨준다.
    private val homePresenter : HomePresenter by lazy{
        HomePresenter(this@HomeFragment, ImageRepository, imageRecyclerAdapter)
    }

    //imageRecyclerAdapter는 adapter이면서 model이다.
    private val imageRecyclerAdapter : ImageRecyclerAdapter by lazy{
        ImageRecyclerAdapter(requireContext())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
            = inflater.inflate(R.layout.fragment_home, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Presenter위에서 정의한 것 가져다가 쓴다.
        homePresenter.loadImage()

        recycler_view.run {
            adapter = imageRecyclerAdapter
            layoutManager = GridLayoutManager(this@HomeFragment.context, 3)
            addOnScrollListener(recyclerViewOnScrollListener)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        recycler_view?.removeOnScrollListener(recyclerViewOnScrollListener)
    }

    private val recyclerViewOnScrollListener = object : RecyclerView.OnScrollListener(){
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            val visibleItemCount = recyclerView?.childCount as Int
            val totalItemCount = imageRecyclerAdapter.itemCount
            var firstVisibleItem = (recyclerView.layoutManager as? GridLayoutManager)?.findFirstVisibleItemPosition() ?: 0
            //GridLayoutManager가 맞으면 첫번째 아이템을 불러오는 것.

            if (!homePresenter.isLoading && (firstVisibleItem + visibleItemCount) >= totalItemCount - 5 ){
                homePresenter.loadImage()
            }


        }
    }

    override fun showImage(imageName: String) {
       /* imageView.setImageResource(R.drawable.sample_01)
        //위와 동일한 형식
        imageView.setImageResource(resources.getIdentifier(imageName,"drawable",
            context?.packageName
        ))*/
    }

    override fun showProgress() {
        progressBar.visibility =View.VISIBLE
    }

    override fun hideProgress() {
        progressBar.visibility =View.GONE
    }
}
