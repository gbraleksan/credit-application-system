package me.dio.credit.request.system.service.impl

import me.dio.credit.request.system.entity.Customer
import me.dio.credit.request.system.exception.BusinessException
import me.dio.credit.request.system.repository.CustomerRepository
import me.dio.credit.request.system.service.ICustomerService
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class CustomerService(
    private val customerRepository: CustomerRepository
) : ICustomerService {
    override fun save(customer: Customer): Customer =
        this.customerRepository.save(customer)

    override fun findById(id: Long): Customer = this.customerRepository.findById(id).orElseThrow {
        throw BusinessException("Id $id not found")
    }

    override fun delete(id: Long) {
        val customer: Customer = this.findById(id)
        this.customerRepository.delete(customer)
    }



}