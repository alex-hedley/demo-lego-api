//package com.baeldung.kotlingradleopenapi
//
//import org.junit.jupiter.api.Assertions.assertEquals
//import org.junit.jupiter.api.Assertions.assertNotNull
//import org.junit.jupiter.api.Test
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.boot.test.context.SpringBootTest
//import org.springframework.boot.test.context.SpringBootTest.WebEnvironment
//import org.springframework.boot.web.server.LocalServerPort
//
//import com.alexhedley.brick.client.model.BrickBody as ClientBrickBody
//import com.alexhedley.legodemo.service.LegoService
//
//@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
//class BrickClientIntegrationTest {
//    @LocalServerPort
//    var serverPort: Int = 0
//
//    @Autowired
//    lateinit var legoService: LegoService
//
//    @Test
//    fun given_spec_client_when_client_method_is_called_then_an_entity_is_created() {
//        val brick = BrickApi("http://localhost:$serverPort")
//                .createBrick(ClientBrickBody(colour = "red", size = "1x1"))
//        assertNotNull(brick)
//        val entityBrick = legoService.getBrick(brick.id)
//        assertNotNull(entityBrick)
//        assertEquals(brick.colour, entityBrick?.colour)
//        assertEquals(brick.shape, entityBrick?.shape)
//    }
//}