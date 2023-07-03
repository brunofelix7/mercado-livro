package me.brunofelix.mercadolivro.extension

import me.brunofelix.mercadolivro.controller.request.CustomerRequest
import me.brunofelix.mercadolivro.model.CustomerModel

fun CustomerRequest.toCustomerModel(id: Int? = null): CustomerModel {
    return CustomerModel(id = id, name = this.name, email = this.email)
}