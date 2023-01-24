package models

val pageOwner = PageOwner(
    avatarUrl = "/static/ana.jpg",
    fullName = "Anastasiia Gromova",
    aboutMe = "Just me, myself and I, exploring the universe of uknownment. " +
            "I have a heart of love and a interest of lorem ipsum and mauris " +
            "neque quam blog. I want to share my world with you.",
    tag = "London",
)

val tagList = listOf<String>(
    "Travel", "New York", "London", "IKEA", "NORWAY", "DIY", "Ideas",
    "Baby", "Family", "News", "Clothing", "Shopping", "Sports", "Games"
)

val postLinks = listOf<PostLink>(
    PostLink("Lorem", "Sed mattis nunc", "/static/box_workshop.jpeg"),
    PostLink("Ipsum", "Praes tinci sed", "/static/box_gondol.jpeg"),
    PostLink("Dorum", "Ultricies congue", "/static/box_skies.jpeg"),
    PostLink("Mingsum", "Lorem ipsum dipsum", "/static/box_rock.jpeg"),
)

data class PageOwner(
    val avatarUrl: String,
    val fullName: String,
    val aboutMe: String,
    val tag: String,
)

data class PostLink(
    val title: String,
    val subtitle: String,
    val imageUrl: String,
)

//data class TagBlock(
//    val tagList: List<String>,
//    val selected: String
//)
