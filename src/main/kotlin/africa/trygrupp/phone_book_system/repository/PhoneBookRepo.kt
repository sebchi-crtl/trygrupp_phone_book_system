package africa.trygrupp.phone_book_system.repository

import africa.trygrupp.phone_book_system.entity.PhoneBook
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PhoneBookRepo : JpaRepository<PhoneBook, Long> {

}