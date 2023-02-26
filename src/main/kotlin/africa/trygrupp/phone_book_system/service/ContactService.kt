package africa.trygrupp.phone_book_system.service

import africa.trygrupp.phone_book_system.entity.PhoneBook
import java.util.*

interface ContactService {

    fun getAllContacts(): Collection<PhoneBook>

    fun findByContactId(id: Long): Optional<PhoneBook>

    fun insert(phoneBook: PhoneBook): PhoneBook

    fun deleteContact(id: Long)

    fun deleteAllContacts()
}
