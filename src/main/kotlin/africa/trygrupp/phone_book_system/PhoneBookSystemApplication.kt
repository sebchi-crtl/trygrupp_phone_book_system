package africa.trygrupp.phone_book_system

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing
class PhoneBookSystemApplication

fun main(args: Array<String>) {
	runApplication<PhoneBookSystemApplication>(*args)
}
