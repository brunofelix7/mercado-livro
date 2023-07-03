package me.brunofelix.mercadolivro.model

import me.brunofelix.mercadolivro.enums.BookStatus
import java.math.BigDecimal
import javax.persistence.*

@Entity(name = "books")
data class BookModel(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Int? = null,

        @Column
        var name: String,

        @Column
        var price: BigDecimal,

        @Column
        @Enumerated(EnumType.STRING)
        var status: BookStatus? = null,

        @ManyToOne
        @JoinColumn(name = "customer_id")
        var customer: CustomerModel? = null
)