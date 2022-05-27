package me.brunofelix.mercadolivro.extension

import me.brunofelix.mercadolivro.controller.request.PostCustomerRequest
import me.brunofelix.mercadolivro.controller.request.PutCustomerRequest
import me.brunofelix.mercadolivro.model.CustomerModel

fun PostCustomerRequest.toCustomerModel(): CustomerModel {
    return CustomerModel(name = this.name, email = this.email)
}

fun PutCustomerRequest.toCustomerModel(id: String): CustomerModel {
    return CustomerModel(id = id, name = this.name, email = this.email)
}
