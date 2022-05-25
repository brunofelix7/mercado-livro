package me.brunofelix.mercadolivro.controller

import me.brunofelix.mercadolivro.controller.request.CustomerRequest
import me.brunofelix.mercadolivro.model.CustomerModel
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("customers")
class CustomerController {

    @GetMapping
    fun getCustomer(): CustomerModel {
        return CustomerModel("1", "Bruno", "brunofelix.dev@gmail.com")
    }

    @PostMapping
    fun create(@RequestBody customer: CustomerRequest) {
        println(customer)
    }
}