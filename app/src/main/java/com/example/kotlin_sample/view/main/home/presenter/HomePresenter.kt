package com.example.kotlin_sample.view.main.home.presenter

import android.os.AsyncTask
import com.example.kotlin_sample.data.source.PhotoResponse
import com.example.kotlin_sample.data.source.flickr.FlickrRepository
import com.example.kotlin_sample.data.source.image.ImageRepository
import com.example.kotlin_sample.util.random
import com.example.kotlin_sample.view.main.home.adapter.model.ImageRecyclerModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomePresenter(val view :HomeContract.View,
                    private val flickrRepository : FlickrRepository,
                    private val imageRepository : ImageRepository,
                    private val imageRecyclerModel : ImageRecyclerModel) : HomeContract.Presenter{

   /* //AsyncTask를 통해서 랜덤하게 이미지를 가져올 예정
    override fun loadImage() {
        ImageAsyncTask(this,view, imageRepository,imageRecyclerModel).execute() //view를 AsyncTask로 넘겨준다. ImageAsyncTask는 static 클래스이다.
    }*/

    var isLoading = false

    private val perPage = 50
    private var page = 0

    /*내 예시---*/


    override fun SearchKeyword(key: String) {
        imageRecyclerModel.refreshItem()
        loadFlickrImage(key)
    }


    private lateinit var resultKey : String
    private val Keyword : String = "Eiffel Tower"

    override fun loadFlickrImage(keys: String) {
        isLoading = true
        view.showProgress()

        if (keys.length==0){
            resultKey = Keyword
        }else{
            resultKey = keys
        }

        flickrRepository.getSearchPhoto(resultKey,++page,perPage) //1페이지로 시작, 한 페이지당 50개씩 가져옴.
            .enqueue(object : Callback<PhotoResponse>{
                override fun onFailure(call: Call<PhotoResponse>, t: Throwable) {
                    view.hideProgress()
                    view.showLoadFail()
                    isLoading = false
                }

                override fun onResponse(call: Call<PhotoResponse>, response: Response<PhotoResponse>) {
                    if (response?.isSuccessful == true){
                        response.body().takeIf { it?.stat == "ok" }?.let{
                            //성공한 경우만 Adapter에 item추가.
                            page = it.photos.page

                            it.photos.photo.forEach {
                                imageRecyclerModel.addItem(it)
                            }
                            imageRecyclerModel.notifyDataSetChange()

                        } ?: let{
                            view.showLoadFail("Code ${response.body()?.code} message : ${response.body()?.message}")
                        }
                    }else{
                        view.showLoadFail()
                    }

                    view.hideProgress()
                    isLoading = false

                }
            })
    }



    /*  //AsyncTask를 inner로 사용하면 메모리 leak이 발생한다.
      class ImageAsyncTask(val homePresenter: HomePresenter,
                           val view : HomeContract.View,
                           private val imageRepository : ImageRepository,
                           private val imageRecyclerModel : ImageRecyclerModel) : AsyncTask<Unit, Unit, Unit>() {
          override fun doInBackground(vararg params: Unit?){
              imageRepository.loadImageList({
                  it.forEach {
                      imageRecyclerModel.addItem(it)
                  }
              },10)
              //Thread.sleep(1000)
              //모델에 해당하는 부분. 나중에 이부분을 분리해서 model값을 받아온다.
          }

          override fun onPreExecute() {
              super.onPreExecute()
              homePresenter.isLoading = true
              view.showProgress()
          }

          override fun onPostExecute(result: Unit?) {
              super.onPostExecute(result)

              imageRecyclerModel.notifyDataSetChange()
              view.hideProgress()
              homePresenter.isLoading = false

              //이전 예제
              //null이 넘어올 수 있으니 null이 아닌 경우에만 넘긴다.
             imageRepository.loadImageFileName {
                 view.showImage(it)
             }
          }
      }*/

}