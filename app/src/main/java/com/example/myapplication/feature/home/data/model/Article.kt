package com.example.myapplication.feature.home.data.model

import com.example.myapplication.feature.home.domain.entity.NewsItemEntity

data class Article(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String?
)

fun Article.toNewsItem(): NewsItemEntity {
    return NewsItemEntity(
        title= title,
        source = source.name,
        imageUrl = urlToImage ?: "",
        publishedAt = publishedAt,
        url = url

    )
}


val dummyNewsList = listOf(
    Article(
        source = Source(id = "cnn", name = "CNN"),
        author = "John Doe",
        title = "Global Markets Rally as Inflation Slows Down",
        description = "Stocks around the world rallied today after new data showed a decline in global inflation.",
        url = "https://www.cnn.com/2025/07/17/markets/global-rally",
        urlToImage = "https://cdn.cnn.com/cnnnext/dam/assets/210719103403-stock-market-nyse-0721-super-tease.jpg",
        publishedAt = "2025-07-17T08:30:00Z",
        content = "Stocks surged globally as inflation data came in lower than expected..."
    ),
    Article(
        source = Source(id = "bbc", name = "BBC News"),
        author = "Jane Smith",
        title = "UK Heatwave: Record Temperatures Hit London",
        description = "Temperatures in London reached a record high this week, sparking concerns about climate change.",
        url = "https://www.bbc.com/news/uk-weather-2025-heatwave",
        urlToImage = "https://ichef.bbci.co.uk/news/976/cpsprodpb/9A02/production/_119429694_londonheat.jpg",
        publishedAt = "2025-07-16T15:45:00Z",
        content = "The UK experienced an extreme heatwave today with London hitting new records..."
    ),
    Article(
        source = Source(id = "techcrunch", name = "TechCrunch"),
        author = "Emily Zhang",
        title = "AI Startups See Spike in Funding in Q3",
        description = "Investments in AI startups surged in Q3 of 2025, with record-breaking funding rounds.",
        url = "https://techcrunch.com/2025/07/17/ai-funding-boom",
        urlToImage = "https://techcrunch.com/wp-content/uploads/2021/05/GettyImages-1176425555.jpg",
        publishedAt = "2025-07-17T10:15:00Z",
        content = "AI-focused startups have received over $10 billion in funding this quarter..."
    ),
    Article(
        source = Source(id = "nyt", name = "New York Times"),
        author = "Michael Brown",
        title = "NASA Launches New Mars Rover",
        description = "NASA has successfully launched its latest Mars rover to explore possible signs of life.",
        url = "https://www.nytimes.com/2025/07/17/science/nasa-mars-launch.html",
        urlToImage = "https://static01.nyt.com/images/2020/07/30/science/30marsrover-promo/30marsrover-promo-videoSixteenByNineJumbo1600.jpg",
        publishedAt = "2025-07-17T12:00:00Z",
        content = "The rover is expected to land on Mars in early 2026 and will explore the Jezero Crater..."
    ),
    Article(
        source = Source(id = "reuters", name = "Reuters"),
        author = "Sophie Lee",
        title = "Oil Prices Dip Ahead of OPEC+ Meeting",
        description = "Oil prices declined slightly as traders await the outcome of the upcoming OPEC+ talks.",
        url = "https://www.reuters.com/business/energy/oil-prices-fall-2025-07-17/",
        urlToImage = "https://www.reuters.com/resizer/kqLCcFwMknvqZAHtLs7Ap4sZEqY=/1440x810/smart/filters:quality(80)/cloudfront-us-east-1.images.arcpublishing.com/reuters/ZBLFZFY3XBJH5AS7WDRGVJKRIE.jpg",
        publishedAt = "2025-07-17T06:00:00Z",
        content = "Oil prices saw a modest decline as markets awaited clarity on OPEC+ supply decisions..."
    )
)
