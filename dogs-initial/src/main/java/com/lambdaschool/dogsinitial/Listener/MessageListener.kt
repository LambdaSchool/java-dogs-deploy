package com.lambdaschool.dogsinitial.Listener

import com.lambdaschool.dogsinitial.DogsinitialApplication
import com.lambdaschool.dogsinitial.Model.MessageDetails
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Service

@Service
class MessageListener{

    @RabbitListener(queues = [DogsinitialApplication.QUEUE_NAME_HIGH])
    fun recieveMessage(msg: MessageDetails){
        println("Message recieved: $msg")
    }

    @RabbitListener(queues = [DogsinitialApplication.QUEUE_NAME_LOW])
    fun recieveLowMessage(msg: MessageDetails){
        println("Message revieved: $msg")
    }
}