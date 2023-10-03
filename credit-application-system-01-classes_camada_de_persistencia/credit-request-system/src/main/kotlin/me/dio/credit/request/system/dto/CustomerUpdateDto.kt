package me.dio.credit.request.system.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import me.dio.credit.request.system.entity.Customer
import java.math.BigDecimal

data class CustomerUpdateDto(
    @field:NotEmpty(message = "Nome não pode ser em branco") val firstName: String,
    @field:NotEmpty(message = "Nome não pode ser em branco") val lastName: String,
    @field:NotNull(message = "Salário não pode ser vazio") val income: BigDecimal,
    @field:NotEmpty(message = "Nome não pode ser em branco") val zipCode: String,
    @field:NotEmpty(message = "Nome não pode ser em branco") val street: String
) {

    fun toEntity(customer: Customer): Customer {
        customer.firstName = this.firstName
        customer.lastName = this.lastName
        customer.income = this.income
        customer.address.zipCode = this.zipCode
        customer.address.street = this.street

        return customer
    }

}
