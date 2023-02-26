package africa.trygrupp.phone_book_system.exception


import java.time.ZonedDateTime

class ApiException(
    var status: Int? = null,
    var message: String? = null,
    var timestamp: ZonedDateTime? = null
    )