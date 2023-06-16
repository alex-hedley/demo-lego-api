package com.alexhedley.legodemo.service

import org.springframework.stereotype.Component
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.atomic.AtomicInteger

@Component
class LegoService {
    private val bricks: ConcurrentHashMap<Int, Brick> = ConcurrentHashMap()
    private val size = AtomicInteger(0)

    fun createBrick(colour: String, shape: String): Brick =
        Brick(size.getAndIncrement(), colour, shape).also {
            bricks[it.id] = it
        }

    fun getBrick(id: Int): Brick? = bricks[id]

    fun getAllBricks(): List<Brick> = bricks.values.toList()

    fun setColour(brickId: Int, colour: String) {
        bricks[brickId] = bricks[brickId]?.copy(colour = colour) ?: throw IllegalArgumentException("Not found")
    }
}