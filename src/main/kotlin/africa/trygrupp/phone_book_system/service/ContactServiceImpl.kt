package africa.trygrupp.phone_book_system.service

import africa.trygrupp.phone_book_system.entity.PhoneBook
import africa.trygrupp.phone_book_system.exception.PhoneBookNotValidException
import africa.trygrupp.phone_book_system.repository.PhoneBookRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import mu.KotlinLogging
import java.util.*


@Service
class ContactServiceImpl: ContactService {
    private val log = KotlinLogging.logger {}

    @Autowired lateinit var phone_book_repo: PhoneBookRepo

    override fun getAllContacts(): Collection<PhoneBook> {
        log.info("Finding Contacts!!!")
        val findAll = phone_book_repo.findAll()

        if (findAll.isEmpty()) {
            log.info("No contact found!!!")
            throw PhoneBookNotValidException("No Contact found in the database")
        }

        log.info("contacts found $findAll")
        return findAll
    }

    override fun findByContactId(id: Long): Optional<PhoneBook> {
        log.info("Finding Contact!!!")
        try {
            val findId = phone_book_repo.findById(id)

            if(findId.isEmpty || !findId.isPresent)
                throw PhoneBookNotValidException("no contact with this id ")
            else
                log.info("contacts found in id: $id")
            return findId
        }
        catch (ex: PhoneBookNotValidException){
            log.info("No contact found!!!")

            throw PhoneBookNotValidException("no contact with this id ")
        }

    }

    override fun insert(phoneBook: PhoneBook): PhoneBook {
        try {
            var insert = phone_book_repo.save(phoneBook)
            log.info("${phoneBook.name}, added!!!")
            return insert
        }
        catch (ex: PhoneBookNotValidException){
            log.info("${phoneBook.name}, not added!!!")
            throw PhoneBookNotValidException("Can not add contact to phonebook")
        }

    }

    override fun deleteContact(id: Long) {
        log.info("Finding Contact ID!!!")

        try {
            val findId = phone_book_repo.findById(id)

            if(findId.isEmpty || !findId.isPresent)
                throw PhoneBookNotValidException("no contact with this id to delete")

            phone_book_repo.deleteById(id)

            log.info("contact deleted")
        }
        catch (ex: PhoneBookNotValidException){
            log.info("cannot be deleted!!!")

            throw PhoneBookNotValidException("Can not delete contact with id: $id")
        }
    }

    override fun deleteAllContacts() {
        phone_book_repo.deleteAll()
        log.info("All users deleted!!")
    }


}
