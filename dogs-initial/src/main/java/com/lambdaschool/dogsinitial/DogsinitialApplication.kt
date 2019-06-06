package com.lambdaschool.dogsinitial


import org.springframework.amqp.core.Binding
import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.Queue
import org.springframework.amqp.core.TopicExchange
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.servlet.DispatcherServlet
import org.springframework.web.servlet.config.annotation.EnableWebMvc

@EnableWebMvc
@SpringBootApplication
open class DogsinitialApplication {


    companion object {
        private lateinit var ourDogList: DogList

        const val EXCHANGE_NAME = "Exchange"
        const val QUEUE_NAME_HIGH = "HighPriorityQueue"
        const val QUEUE_NAME_LOW = "LowPriorityQueue"

        @JvmStatic
        fun main(args: Array<String>) {
            ourDogList = DogList()
            val ctx = SpringApplication.run(DogsinitialApplication::class.java, *args)

            val dispatcherServlet = ctx.getBean("dispatcherServlet") as DispatcherServlet
            dispatcherServlet.setThrowExceptionIfNoHandlerFound(true)
        }

        fun getOurDogList() : DogList = ourDogList


    }

    @Bean
    fun appExchange(): TopicExchange {
        return TopicExchange(EXCHANGE_NAME)
    }

    @Bean
    fun appQueueHigh(): Queue {
        return Queue(QUEUE_NAME_HIGH)
    }

    @Bean
    fun declareBindingHigh(): Binding {
        return BindingBuilder.bind(appQueueHigh()).to(appExchange()).with(QUEUE_NAME_HIGH)
    }

    @Bean
    fun appQueueLow(): Queue {
        return Queue(QUEUE_NAME_LOW)
    }

    @Bean
    fun declareBindingLow(): Binding {
        return BindingBuilder.bind(appQueueLow()).to(appExchange()).with(QUEUE_NAME_LOW)
    }

    @Bean
    fun producerJackson2MessageConverter(): Jackson2JsonMessageConverter {
        return Jackson2JsonMessageConverter()
    }
}