package app.prachang.dummy_data.facebook

data class FacebookDataModel(
    val name: String,
    val profile: String,
    val time: String,
    val likes: String,
    val comments: String,
    val shares: String,
    val postImage: String,
    val postDescription: String,
)


object FacebookData {
    val dashboardPosts = listOf(
        FacebookDataModel(
            name = "Cristiano Ronaldo",
            profile = "https://upload.wikimedia.org/wikipedia/commons/8/8c/Cristiano_Ronaldo_2018.jpg",
            time = "2 mins",
            likes = "12k Likes",
            comments = "230 Comments",
            shares = "13 Shares",
            postImage = "https://i2-prod.mirror.co.uk/incoming/article25792702.ece/ALTERNATES/s615b/0_Cristiano-Ronaldo.jpg",
            postDescription = "Have yourself a Merry little Christmas, let your heart be light. May this Christmas season bring you closer to all those that you treasure in your heart. Have a Merry Christmas and a Happy New year! I hope Santa is good to you this year because you only deserve the best. Merry Christmas from our family to yours."
        ),

        FacebookDataModel(
            name = "Lionel Messi",
            profile = "https://library.sportingnews.com/styles/crop_style_16_9_mobile_2x/s3/2021-08/lionel-messi-barcelona_1yojy2xfu73113vl8uaoqe9yd.jpg?itok=NhxrQaOC",
            time = "12 june",
            likes = "12m Likes",
            comments = "8m Comments",
            shares = "280k Shares",
            postImage = "https://i.pinimg.com/564x/e9/a1/43/e9a14344b3e67df8edc2c70e244cab77.jpg",
            postDescription = "A few tips for coaches to write a speech for the team include having a clear purpose, stepping in the team's shoes, sharing stories and being vulnerable, writing how you talk, being persuasive, and concluding well."
        ),
        FacebookDataModel(
            name = "The Rock",
            profile = "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1f/Dwayne_Johnson_2014_%28cropped%29.jpg/640px-Dwayne_Johnson_2014_%28cropped%29.jpg",
            time = "13 june",
            likes = "18m Likes",
            comments = "14m Comments",
            shares = "290k Shares",
            postImage = "https://static.standard.co.uk/s3fs-public/thumbnails/image/2018/11/19/15/dwaynejohnson1911.jpg?width=968&auto=webp&quality=50&crop=968%3A645%2Csmart",
            postDescription = "The definition of a description is a statement that gives details about someone or something. An example of description is a story about the places visited on a family trip. noun. 33."
        ),
    )
}