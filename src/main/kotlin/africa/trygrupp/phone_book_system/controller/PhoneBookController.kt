package africa.trygrupp.phone_book_system.controller

import africa.trygrupp.phone_book_system.entity.PhoneBook
import africa.trygrupp.phone_book_system.service.ContactService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("api/v1/contact")
class PhoneBookController{
    @Autowired lateinit var contactService: ContactService

    @GetMapping("hello")
    fun hello(): String {
        return "HelloWorld"
    }

    @GetMapping(value = ["", "/"])
    fun fetchAllContact() : ResponseEntity<Collection<PhoneBook>> {
        var allContacts = contactService.getAllContacts()

        return if (!allContacts.isEmpty()) ResponseEntity.ok(allContacts) else ResponseEntity
            .notFound().build()
    }

    @GetMapping("{id}")
    fun getContactById(@PathVariable("id") id: Long): ResponseEntity<Optional<PhoneBook>> {
        val contact = contactService.findByContactId(id)

        return if (contact.isPresent) ResponseEntity.ok(contact) else ResponseEntity
            .notFound().build()
    }

    @PostMapping
    fun postContact(@RequestBody phoneBook: PhoneBook): ResponseEntity<Any> {
        val insert = contactService.insert(phoneBook)
        return if (insert != null) ResponseEntity.ok(insert) else ResponseEntity
            .notFound().build()
    }

    @DeleteMapping("{id}")
    fun deleteRestaurantId(@PathVariable id: Long) =

        ResponseEntity.ok(contactService.deleteContact(id))

    @DeleteMapping
    fun deleteUsers() =
        contactService.deleteAllContacts()


}