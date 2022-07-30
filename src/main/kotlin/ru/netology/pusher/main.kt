package ru.netology.pusher

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import java.io.FileInputStream


fun main() {
    val options = FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(FileInputStream("fcm.json")))
        .build()

    FirebaseApp.initializeApp(options)

//    val message = Message.builder()
//        .putData("action", "LIKE")
//        .putData("content", """{
//          "userId": 1,
//          "userName": "Vasiliy",
//          "postId": 2,
//          "postAuthor": "Netology"
//        }""".trimIndent())
//        .setToken("cdAlAFNnR2iPPQUq68_J4V:APA91bGOm7uqgu4canth8X1FI5PR4edgLFY8vPr8XsZ2wxLlM63PgrsMOkOK1BQqIa5gaQTqW7wKzqw9fNJ7FFFiFbyvDTK_DpY6Wvc9TKJUL_EkbmxPuXfA_6JX_fPjr-W8dv9WMG43")
//        .build()
//
//    FirebaseMessaging.getInstance().send(message)

    val messageNewPost = Message.builder()
        .putData("action", "NEW_POST")
        .putData(
            "content", """{
          "userId": 1,
          "userName": "Vasiliy",
          "postId": 2,
          "postText": "Факелы Ростральных колонн дважды зажгут в честь Дня ВМФ в Петербурге. Пламя вспыхнет на факелах Ростральных колонн в День ВМФ дважды — перед началом и во время Главного военно-морского парада, а также вечером. Факелы зажгут с 10:00 до 14:00, а вечером с 21:00 до 23:30. Таким образом город дополнит праздничное убранство, подготовленное ко Дню военно-морского флота (ВМФ). В ночь на 1 августа также огни раскрасят в цвета Андреевского флага Дворцовый мост. Полюбоваться подсветкой можно будет с 22:10 до 00:45, рассказали в пресс-службе Смольного. Зажигать факелы Ростральных колонн в Петербурге принято по памятным датам. Последний раз это происходило в начале июля — в честь победы Зенита в Суперкубке. День ВМФ с размахом отпразднуют в Петербурге 31 июля. Помимо военно-морского парада планируется выступление Дважды Краснознаменного Академического ансамбля имени Александрова, а вечером на Дворцовой покажут самую известную в стране рок-оперу Юнона и Авось."
        }""".trimIndent()
        )
        .setToken("cdAlAFNnR2iPPQUq68_J4V:APA91bGOm7uqgu4canth8X1FI5PR4edgLFY8vPr8XsZ2wxLlM63PgrsMOkOK1BQqIa5gaQTqW7wKzqw9fNJ7FFFiFbyvDTK_DpY6Wvc9TKJUL_EkbmxPuXfA_6JX_fPjr-W8dv9WMG43")
        .build()

    FirebaseMessaging.getInstance().send(messageNewPost)
}
