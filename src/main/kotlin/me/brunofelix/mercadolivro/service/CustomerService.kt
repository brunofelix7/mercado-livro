package me.brunofelix.mercadolivro.service

import me.brunofelix.mercadolivro.model.CustomerModel
import me.brunofelix.mercadolivro.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(
    private val repository: CustomerRepository
) {

    fun create(customer: CustomerModel) {
        repository.save(customer)
    }

    fun delete(id: Int) {
        if (!repository.existsById(id)) {
            throw Exception()
        }
        repository.deleteById(id)
    }

    fun update(customer: CustomerModel) {
        if (!repository.existsById(customer.id!!)) {
            throw Exception()
        }
        repository.save(customer)
    }

    fun getCustomer(id: Int): CustomerModel {
        return repository.findById(id).orElseThrow()
    }

    fun getAll(name: String?): List<CustomerModel> {
        name?.let {
            return repository.findByNameContaining(it)
        }
        return repository.findAll().toList()
    }
}
