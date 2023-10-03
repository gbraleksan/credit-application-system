package me.dio.credit.request.system.dto

import java.math.BigDecimal
import java.time.LocalDate
import jakarta.validation.constraints.Future
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import me.dio.credit.request.system.entity.Credit
import me.dio.credit.request.system.entity.Customer

data class CreditDto(
    @field:NotNull(message = "Valor de crédito não pode ser vazio") val creditValue: BigDecimal,
    @field:Future(message = "Data incorreta") val dayFirstInstallment: LocalDate,
    @field:Size(min = 1, max = 48, message = "Numero de parcelas máximas é de 48")val numberOfInstallments: Int,
    @field:NotNull(message = "Id do cliente não pode ser vazio") val customerId: Long
) {

    fun toEntity(): Credit = Credit(
        creditValue = this.creditValue,
        dayFirstInstallment = this.dayFirstInstallment,
        numberOfInstallments = this.numberOfInstallments,
        customer = Customer(id = this.customerId)
    )

}
