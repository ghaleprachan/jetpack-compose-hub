package app.prachang.dummy_data.gmail

import java.util.*

object MailsData {

    val generateUrl: (name: String) -> String = { name ->
        "https://ui-avatars.com/api/?name=$name/"
    }

    enum class Tags {
        Email, Promotions, Social,
    }

    data class MailsData(
        val id: String = UUID.randomUUID().toString(),
        val sender: String? = null,
        val image: String? = null,
        val subTitle: String? = null,
        val body: String? = null,
        val dataTime: String? = null,
        val tags: Tags = Tags.Email,
        val isRead: Boolean = false
    )

    val mails = listOf(
        MailsData(tags = Tags.Promotions),
        MailsData(
            sender = "External Partnership",
            image = generateUrl("Ex+Part"),
            subTitle = "Vacancy and Internship Opening Announcement from Computing students!",
            body = "Dear students, This is to inform you that, there are vacancies for following positions.",
            dataTime = "4:06 pm",
            isRead = true,
        ),
        MailsData(tags = Tags.Social),
        MailsData(
            sender = "Google Play | Apps & Games",
            image = generateUrl("Google+Play"),
            subTitle = "Unknown | First developer preview of android 13. See from link below!",
            body = "What's new in Android and google play services. We have added many extra new features.",
            dataTime = "7:17 am",
        ),
        MailsData(
            sender = "Google Local Guides",
            image = generateUrl("Google+Local"),
            subTitle = "Prachan, your February Newsletter has arrived.",
            body = "Being a local guide means being helpful whenever and wherever you can.",
            dataTime = "27 Feb",
        ),
        MailsData(
            sender = "Quora Digest",
            image = generateUrl("Qu+Di"),
            subTitle = "How hard is Nepali language?",
            body = "As with any foreign language, the difficult depends upon your mother tongue.",
            dataTime = "27 Feb",
        ),
        MailsData(
            sender = "Quora Digest",
            image = generateUrl("Qu+Di"),
            subTitle = "Do Australians really like skilled immigrants coming in and developing country?",
            body = "I migrated to australia under skilled migration program 22 years ago - I think I am qualified to answer.",
            dataTime = "26 Feb",
        ),
        MailsData(
            sender = "Sanfoundry",
            image = generateUrl("Sanfoundry"),
            subTitle = "Practice Android Jave Programs",
            body = "Sandfoundry Technology Eduction Blog written by Mr. Prachan Ghale",
            dataTime = "26 Feb",
        ),
        MailsData(
            sender = "Google Local Guides",
            image = generateUrl("Go+Lo"),
            subTitle = "Bet you don't know what today is--open to find out!",
            body = "Congratulations on reaching this milestone. On behalf of billion other Maps users across the globe.",
            dataTime = "25 Feb",
        ),
        MailsData(
            sender = "StacksShare Weekly",
            image = generateUrl("St+We"),
            subTitle = "Observability for matrics via SQL, a GraphQL, and Webhooks as Service",
            body = "Sponsored by CircleCI, Let CircleCI focus on CI/CD, so you can build next big thing.",
            dataTime = "25 Feb",
            isRead = true,
        ),
        MailsData(
            sender = "External Partnership",
            image = generateUrl("Ex+Part"),
            subTitle = "Vacancy and Internship Opening Announcement from Computing students!",
            body = "Dear students, This is to inform you that, there are vacancies for following positions.",
            dataTime = "4:06 pm",
            isRead = true,
        ),
        MailsData(
            sender = "Google Play | Apps & Games",
            image = generateUrl("Google+Play"),
            subTitle = "Unknown | First developer preview of android 13. See from link below!",
            body = "What's new in Android and google play services. We have added many extra new features.",
            dataTime = "7:17 am",
        ),
        MailsData(
            sender = "Google Local Guides",
            image = generateUrl("Google+Local"),
            subTitle = "Prachan, your February Newsletter has arrived.",
            body = "Being a local guide means being helpful whenever and wherever you can.",
            dataTime = "27 Feb",
        ),
        MailsData(
            sender = "Quora Digest",
            image = generateUrl("Qu+Di"),
            subTitle = "How hard is Nepali language?",
            body = "As with any foreign language, the difficult depends upon your mother tongue.",
            dataTime = "27 Feb",
        ),
        MailsData(
            sender = "Quora Digest",
            image = generateUrl("Qu+Di"),
            subTitle = "Do Australians really like skilled immigrants coming in and developing country?",
            body = "I migrated to australia under skilled migration program 22 years ago - I think I am qualified to answer.",
            dataTime = "26 Feb",
        ),
        MailsData(
            sender = "Sanfoundry",
            image = generateUrl("Sanfoundry"),
            subTitle = "Practice Android Jave Programs",
            body = "Sandfoundry Technology Eduction Blog written by Mr. Prachan Ghale",
            dataTime = "26 Feb",
        ),
        MailsData(
            sender = "Google Local Guides",
            image = generateUrl("Go+Lo"),
            subTitle = "Bet you don't know what today is--open to find out!",
            body = "Congratulations on reaching this milestone. On behalf of billion other Maps users across the globe.",
            dataTime = "25 Feb",
        ),
        MailsData(
            sender = "StacksShare Weekly",
            image = generateUrl("St+We"),
            subTitle = "Observability for matrics via SQL, a GraphQL, and Webhooks as Service",
            body = "Sponsored by CircleCI, Let CircleCI focus on CI/CD, so you can build next big thing.",
            dataTime = "25 Feb",
            isRead = true,
        ),
        MailsData(
            sender = "External Partnership",
            image = generateUrl("Ex+Part"),
            subTitle = "Vacancy and Internship Opening Announcement from Computing students!",
            body = "Dear students, This is to inform you that, there are vacancies for following positions.",
            dataTime = "4:06 pm",
            isRead = true,
        ),
        MailsData(
            sender = "Google Play | Apps & Games",
            image = generateUrl("Google+Play"),
            subTitle = "Unknown | First developer preview of android 13. See from link below!",
            body = "What's new in Android and google play services. We have added many extra new features.",
            dataTime = "7:17 am",
        ),
        MailsData(
            sender = "Google Local Guides",
            image = generateUrl("Google+Local"),
            subTitle = "Prachan, your February Newsletter has arrived.",
            body = "Being a local guide means being helpful whenever and wherever you can.",
            dataTime = "27 Feb",
        ),
        MailsData(
            sender = "Quora Digest",
            image = generateUrl("Qu+Di"),
            subTitle = "How hard is Nepali language?",
            body = "As with any foreign language, the difficult depends upon your mother tongue.",
            dataTime = "27 Feb",
        ),
        MailsData(
            sender = "Quora Digest",
            image = generateUrl("Qu+Di"),
            subTitle = "Do Australians really like skilled immigrants coming in and developing country?",
            body = "I migrated to australia under skilled migration program 22 years ago - I think I am qualified to answer.",
            dataTime = "26 Feb",
        ),
        MailsData(
            sender = "Sanfoundry",
            image = generateUrl("Sanfoundry"),
            subTitle = "Practice Android Jave Programs",
            body = "Sandfoundry Technology Eduction Blog written by Mr. Prachan Ghale",
            dataTime = "26 Feb",
        ),
        MailsData(
            sender = "Google Local Guides",
            image = generateUrl("Go+Lo"),
            subTitle = "Bet you don't know what today is--open to find out!",
            body = "Congratulations on reaching this milestone. On behalf of billion other Maps users across the globe.",
            dataTime = "25 Feb",
        ),
        MailsData(
            sender = "StacksShare Weekly",
            image = generateUrl("St+We"),
            subTitle = "Observability for matrics via SQL, a GraphQL, and Webhooks as Service",
            body = "Sponsored by CircleCI, Let CircleCI focus on CI/CD, so you can build next big thing.",
            dataTime = "25 Feb",
            isRead = true,
        ),
    )
}
