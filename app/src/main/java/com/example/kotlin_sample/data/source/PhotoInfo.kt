package com.example.kotlin_sample.data.source


data class PhotoInfo(
    val photo: PhotoDetail,
    val stat: String
)

data class PhotoDetail(
    val comments: Comments,
    val dates: Dates,
    val dateuploaded: String,
    val description: Description,
    val editability: Editability,
    val farm: Int,
    val id: String,
    val isfavorite: Int,
    val license: Int,
    val media: String,
    val notes: Notes,
    val owner: Owner,
    val people: People,
    val publiceditability: Publiceditability,
    val rotation: Int,
    val safety_level: Int,
    val secret: String,
    val server: String,
    val tags: Tags,
    val title: Title,
    val urls: Urls,
    val usage: Usage,
    val views: Int,
    val visibility: Visibility
){
    fun getImageUrl() = "https://farm$farm.staticflickr.com/$server/${id}_$secret.jpg"
}


data class Comments(
    val _content: Int
)

data class Dates(
    val lastupdate: String,
    val posted: String,
    val taken: String,
    val takengranularity: Int,
    val takenunknown: Int
)

data class Description(
    val _content: String
)

data class Editability(
    val canaddmeta: Int,
    val cancomment: Int
)

data class Notes(
    val note: List<Any>
)

data class Owner(
    val iconfarm: Int,
    val iconserver: Int,
    val location: String,
    val nsid: String,
    val path_alias: String,
    val realname: String,
    val username: String
){
    fun getBuddyIcons() = "http://farm$iconfarm.staticflickr.com/$iconserver/buddyicons/$nsid.jpg"
}

data class People(
    val haspeople: Int
)

data class Publiceditability(
    val canaddmeta: Int,
    val cancomment: Int
)

data class Tags(
    val tag: List<Any>
)

data class Title(
    val _content: String
)

data class Urls(
    val url: List<Url>
)

data class Usage(
    val canblog: Int,
    val candownload: Int,
    val canprint: String,
    val canshare: Int
)

data class Visibility(
    val isfamily: Int,
    val isfriend: Int,
    val ispublic: Int
)

data class Url(
    val _content: String,
    val type: String
)