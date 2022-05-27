package me.brunofelix.mercadolivro.controller

import me.brunofelix.mercadolivro.controller.request.PostCustomerRequest
import me.brunofelix.mercadolivro.controller.request.PutCustomerRequest
import me.brunofelix.mercadolivro.extension.toCustomerModel
import me.brunofelix.mercadolivro.model.CustomerModel
import me.brunofelix.mercadolivro.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("customers")
class CustomerController(
    private val service: CustomerService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody customer: PostCustomerRequest) {
        service.create(customer.toCustomerModel())
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int) {
        service.delete(id)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Int, @RequestBody customer: PutCustomerRequest) {
        service.update(customer.toCustomerModel(id))
    }

    @GetMapping("/{id}")
    fun getCustomer(@PathVariable id: Int): CustomerModel {
        return service.getCustomer(id)
    }

    @GetMapping
    fun getAll(@RequestParam name: String?): List<CustomerModel> {
        return service.getAll(name)
    }
}
