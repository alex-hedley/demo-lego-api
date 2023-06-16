//package com.alexhedley.legodemo.api
//
//import com.alexhedley.BrickBody
//import com.alexhedley.BricksApi
//import com.alexhedley.legodemo.service.Brick
//import org.springframework.http.ResponseEntity
//import org.springframework.web.bind.annotation.RequestMapping
//import org.springframework.web.bind.annotation.RestController
//
//import com.alexhedley.legodemo.service.LegoService
//import com.alexhedley.legodemo.service.Brick as BrickModel
//
//@RestController
//@RequestMapping("/v1/bricks")
//class BrickCrudController(private val legoService: LegoService) : BricksApi {
//    override fun createBrick(brickBody: BrickBody): ResponseEntity<Brick> {
//        val (colour, shape) = brickBody
//        return legoService.createBrick(colour, shape)
//                .let { ResponseEntity.ok(it.toApiBrick()) }
//    }
//
//    override fun getBrick(id: Int): ResponseEntity<Brick> {
//        return legoService.getBrick(id)?.toApiBrick()
//                ?.let { ResponseEntity.ok(it) }
//                ?: throw IllegalArgumentException("Brick by id $id is not found")
//    }
//
//    override fun getBricks(): ResponseEntity<List<Brick>> {
//        return legoService.getAllBricks().map { it.toApiBrick() }
//            .let { ResponseEntity.ok(it) }
//    }
//
//    private fun BrickModel.toApiBrick(): Brick = Brick(
//        id = id,
//        colour = colour,
//        shape = shape
//    )
//}