package me.dio.credit.request.system.exception

data class BusinessException(override val message: String?) : RuntimeException(message)