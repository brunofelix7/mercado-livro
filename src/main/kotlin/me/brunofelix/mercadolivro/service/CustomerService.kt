package me.brunofelix.mercadolivro.service

import me.brunofelix.mercadolivro.model.CustomerModel
import org.springframework.stereotype.Service

@Service
class CustomerService {

    val customersList = mutableListOf<CustomerModel>()

    fun create(customer: CustomerModel) {
        val id = if (customersList.isEmpty()) {
            1
        } else {
            customersList.last().id!!.toInt() + 1
        }.toString()

        customer.id = id

        customersList.add(customer)
    }

    fun delete(id: String) {
        customersList.removeIf { it.id == id }
    }

    fun update(customer: CustomerModel) {
        customersList.filter { it.id == customer.id }.first().let {
            it.name = customer.name
            it.email = customer.email
        }
    }

    fun getCustomer(id: String): CustomerModel {
        return customersList.filter { it.id == id }.first()
    }

    fun getAll(name: String?): List<CustomerModel> {
        name?.let {
            return customersList.filter { it.name.contains(name, true) }
        }
        return customersList
    }
}
