package me.dio.credit.request.system.dto

import jakarta.persistence.*
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import me.dio.credit.request.system.entity.Address
import me.dio.credit.request.system.entity.Customer
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal

data class CustomerDTO(
    @field:NotEmpty(message = "Nome não pode ser em branco") val firstName: String,
    @field:NotEmpty(message = "Sobrenome não pode ser em branco")val lastName: String,
    @field:NotEmpty(message = "CPF não pode ser em branco")
    @field:CPF(message = "CPF esta inválido") val cpf: String,
    @field:NotNull(message = "Salário não pode ser vazio") val income: BigDecimal,
    @field:NotEmpty(message = "Email não pode ser em branco")
    @field:Email (message = "Email inválido")val email: String,
    @field:NotEmpty(message = "Senha não pode ser em branco")val password: String,
    @field:NotEmpty(message = "Código Postal não pode ser em branco")val zipCode: String,
    @field:NotEmpty(message = "Rua não pode ser em branco")val street: String,
) {
    fun toEntity(): Customer = Customer(
        firstName = this.firstName,
        lastName = this.lastName,
        cpf = this.cpf,
        income = this.income,
        email = this.email,
        password = this.password,
        address = Address(
            zipCode = this.zipCode,
            street = this.street
        )
    )
}
