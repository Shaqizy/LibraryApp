package com.shayzeq.libraryApp.utils

import org.hibernate.engine.spi.SharedSessionContractImplementor
import org.hibernate.id.enhanced.SequenceStyleGenerator
import org.hibernate.internal.util.config.ConfigurationHelper
import org.hibernate.service.ServiceRegistry
import org.hibernate.type.LongType
import org.hibernate.type.Type
import java.io.Serializable
import java.util.*

class StringIdGenerator : SequenceStyleGenerator() {

    private lateinit var prefix: String
    private lateinit var numberFormat: String

    companion object {
        const val VALUE_PREFIX_PARAMETER: String = "valuePrefix"
        const val VALUE_PREFIX_DEFAULT: String = ""
        const val NUMBER_FORMAT_PARAMETER: String = "numberFormat"
        const val NUMBER_FORMAT_DEFAULT: String = "%d"
    }

    override fun generate(session: SharedSessionContractImplementor?, obj: Any): Serializable {
        return prefix + String.format(numberFormat, super.generate(session, obj))
    }

    override fun configure(type: Type?, params: Properties?, serviceRegistry: ServiceRegistry?) {
        super.configure(LongType.INSTANCE, params, serviceRegistry)
        prefix = ConfigurationHelper.getString(VALUE_PREFIX_PARAMETER, params, VALUE_PREFIX_DEFAULT)
        numberFormat = ConfigurationHelper.getString(NUMBER_FORMAT_PARAMETER, params, NUMBER_FORMAT_DEFAULT)
    }
}