package com.example.kotlin_sample.ImageLoadSample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.kotlin_sample.R
import kotlinx.android.synthetic.main.activity_image_load.*

class ImageLoadActivity : AppCompatActivity() {

    companion object{
        const val ACTION_ASYNC = 0
        const val ACTION_THREAD = 1
    }

    private var actionType = ACTION_ASYNC
    private val imageList = listOf(
        "https://github.com/taehwandev/Kotlin-Udemy-Sample/blob/No42-Image-load-library/app/src/main/res/drawable/sample_01.png?raw=true",
        "https://github.com/taehwandev/Kotlin-Udemy-Sample/blob/No42-Image-load-library/app/src/main/res/drawable/sample_02.png?raw=true",
        "https://github.com/taehwandev/Kotlin-Udemy-Sample/blob/No42-Image-load-library/app/src/main/res/drawable/sample_03.png?raw=true",
        "https://github.com/taehwandev/Kotlin-Udemy-Sample/blob/No42-Image-load-library/app/src/main/res/drawable/sample_04.png?raw=true",
        "https://github.com/taehwandev/Kotlin-Udemy-Sample/blob/No42-Image-load-library/app/src/main/res/drawable/sample_05.png?raw=true",
        "https://github.com/taehwandev/Kotlin-Udemy-Sample/blob/No42-Image-load-library/app/src/main/res/drawable/sample_06.png?raw=true",
        "https://github.com/taehwandev/Kotlin-Udemy-Sample/blob/No42-Image-load-library/app/src/main/res/drawable/sample_07.png?raw=true",
        "https://github.com/taehwandev/Kotlin-Udemy-Sample/blob/No42-Image-load-library/app/src/main/res/drawable/sample_08.png?raw=true",
        "https://github.com/taehwandev/Kotlin-Udemy-Sample/blob/No42-Image-load-library/app/src/main/res/drawable/sample_09.png?raw=true",
        "https://github.com/taehwandev/Kotlin-Udemy-Sample/blob/No42-Image-load-library/app/src/main/res/drawable/sample_10.png?raw=true"
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_load)

        loadTest()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.run {
            inflate(R.menu.main_menu, menu)
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item?.itemId){
            R.id.action_reload ->{
                loadTest()
                true
            }
            R.id.action_async -> {
                actionType = ACTION_ASYNC
                loadTest()
                true
            }
            R.id.action_thread -> {
                actionType = ACTION_THREAD
                loadTest()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun loadTest(){
        val randNumber = (1..imageList.size).random()
        when(actionType){
            ACTION_ASYNC->{
                ImageDownloadAsync.loadImage(R.drawable.ic_home_black_24dp, image_view, imageList[randNumber], tv_title2, randNumber +1)
                    .takeIf { it }?.let { {
                        tv_title2.text = "ACTION_ASYNC cacheLoad : true - $randNumber"
                    } }

            }
            ACTION_THREAD->{
                ImageDownloadThread.loadImage(R.drawable.ic_home_black_24dp, image_view, imageList[randNumber], tv_title2, randNumber +1)
                    .takeIf { it }?.let { {
                        tv_title2.text = "ACTION_ASYNC cacheLoad : true - $randNumber"
                    } }

            }
        }
    }

}
