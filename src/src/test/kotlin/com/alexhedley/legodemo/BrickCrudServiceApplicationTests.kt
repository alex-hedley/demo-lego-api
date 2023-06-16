//package com.baeldung.kotlingradleopenapi
//
//import com.fasterxml.jackson.databind.ObjectMapper
//import org.junit.jupiter.api.Assertions.assertEquals
//import org.junit.jupiter.api.Test
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
//import org.springframework.boot.test.context.SpringBootTest
//import org.springframework.http.MediaType
//import org.springframework.test.web.servlet.MockMvc
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
//
//import com.alexhedley.BrickBody
//import com.alexhedley.legodemo.service.LegoService
//
//@SpringBootTest
//@AutoConfigureMockMvc
//class BrickCrudServiceApplicationTests {
//
//    @Autowired
//    lateinit var legoService: LegoService
//
//    @Autowired
//    lateinit var mockMvc: MockMvc
//
//    @Autowired
//    lateinit var objectMapper: ObjectMapper
//
//    @Test
//    fun when_called_with_proper_data_then_creates_an_entity() {
//        mockMvc.perform(
//            post("/v1/bricks/")
//                .accept(MediaType.APPLICATION_JSON)
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsBytes(brickBodies[0]))
//        )
//        .andExpect(status().isOk)
//        .andExpect(jsonPath("\$.colour").value("red"))
//    }
//
//    @Test
//    fun when_called_on_existing_brick_then_updates_colour() {
//        var newColour = "yellow";
//        brickBodies.forEach { (colour, shape,) ->
//            legoService.createBrick(colour, shape)
//        }
//        mockMvc.perform(
//            post("/v1/bricks/colour/{brickId}", 0)
//                .accept(MediaType.APPLICATION_JSON)
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsBytes(newColour))
//        )
//        .andExpect(status().isAccepted)
//
//        val changedBrick = legoService.getBrick(0)
//        assertEquals(changedBrick?.colour, newColour)
//    }
//
//    companion object {
//        val brickBodies = listOf(
//            BrickBody(colour = "red", shape = "1x1"),
//            BrickBody(colour = "green", shape = "2x4"),
//            BrickBody(colour = "blue", shape = "1x8"),
//        )
//    }
//}