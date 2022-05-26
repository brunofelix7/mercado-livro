package me.brunofelix.mercadolivro.controller

import me.brunofelix.mercadolivro.controller.request.PostCustomerRequest
import me.brunofelix.mercadolivro.controller.request.PutCustomerRequest
import me.brunofelix.mercadolivro.model.CustomerModel
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("customers")
class CustomerController {

    val customersList = mutableListOf<CustomerModel>()

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody customer: PostCustomerRequest) {
        val id = if (customersList.isEmpty()) {
            1
        } else {
            customersList.last().id.toInt() + 1
        }.toString()

        customersList.add(CustomerModel(id, customer.name, customer.email))
    }

    @GetMapping("/{id}")
    fun getCustomer(@PathVariable id: String): CustomerModel {
        return customersList.filter { it.id == id }.first()
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: String) {
        customersList.removeIf { it.id == id }
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: String, @RequestBody customer: PutCustomerRequest) {
        customersList.filter { it.id == id }.first().let {
            it.name = customer.name
            it.email = customer.email
        }
    }

    @GetMapping
    fun getAll(@RequestParam name: String?): List<CustomerModel> {
        name?.let {
            return customersList.filter { it.name.contains(name, true) }
        }
        return customersList
    }
}