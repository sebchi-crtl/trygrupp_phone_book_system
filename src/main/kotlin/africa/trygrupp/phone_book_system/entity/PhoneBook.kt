package africa.trygrupp.phone_book_system.entity

import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.Parameter
import java.time.LocalDateTime


@Entity
@Table(name="app_phone_book")
data class PhoneBook (
    @Id
    @GeneratedValue(generator = "app_phone_book-sequence-generator")
    @GenericGenerator(
        name = "app_phone_book-sequence-generator",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = [
            Parameter(name = "sequence_name", value = "app_phone_book_SEQ"),
            Parameter(name = "initial_value", value = "100"),
            Parameter(name = "increment_size", value = "1")
        ]
    )
    val id: Long = 0,

    @Column(name = "name")
    val name: String = "",

    @Column(name = "phone_number", unique = true)
    val phone_number: String = "",

    @Column(name = "address")
    val address: String = "",

    @Column(name = "created_at")
    val created_at: LocalDateTime = LocalDateTime.now()

)
