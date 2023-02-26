package africa.trygrupp.phone_book_system.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.time.ZoneId
import java.time.ZonedDateTime

@ControllerAdvice
class ControllerAdvisor {

    @ExceptionHandler
    fun handlePhoneBookNotValidException(
        ex: PhoneBookNotValidException
    ): ResponseEntity<ApiException> {
        val apiException = ApiException(
            HttpStatus.NOT_FOUND.value(),
            ex.message,
            ZonedDateTime.now(ZoneId.of("Z"))
        )
        return ResponseEntity(apiException, HttpStatus.NOT_FOUND)
    }

}