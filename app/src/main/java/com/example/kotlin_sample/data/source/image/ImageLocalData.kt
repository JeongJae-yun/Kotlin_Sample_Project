package com.example.kotlin_sample.data.source.image

import com.example.kotlin_sample.data.ImageData
import com.example.kotlin_sample.util.random

class ImageLocalData : ImageDataSource{
    
    //ImageDataSource를 상속받음
    override fun loadImageFileName(fileName: (String) -> Unit) {
        fileName(String.format("sample_%02d",(1..10).random())) //Presenter에서 String.format을 랜덤으로 넘겨주는 return하는 부분에서 잡아옴.
    }

    override fun loadImageList(imageDataList: (List<ImageData>) -> Unit, size: Int) {
        val list = mutableListOf<ImageData>() //ImageData를 갖고있는 list생성
        for (index in 1..size){ //넘어온 size만큼 for문을 돌아서
            val name = String.format("sample_%02d",(1..10).random()) //이름 설정 해두고
            list.add(ImageData(name,name)) //리스트에 넣는다.
        }
        imageDataList(list) //imageDataList에 넣는다. 결국 Activity에서 쓸 것이 imageDataList이다. CallBack으로 리턴해줌ㄴ
    }

}