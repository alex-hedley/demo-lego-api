package com.alexhedley.legodemo.api

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.parameters.RequestBody as OASRequestBody // Need to do this because of https://github.com/swagger-api/swagger-core/issues/3628
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.ok
import org.springframework.web.bind.annotation.*

import com.alexhedley.legodemo.service.LegoService

@RestController
@RequestMapping("/v1/bricks")
class BrickController(private val legoService: LegoService) {
    @Operation(summary = "Sets a colour for a chosen brick", description = "Returns 202 if successful")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "202", description = "Successful Operation"),
            ApiResponse(responseCode = "404", description = "Such a brick does not exist"),
        ]
    )
    @PostMapping("/colour/{brickId}", consumes = ["application/json"])
    fun setColour(
            @PathVariable brickId: Int,
            @RequestBody @OASRequestBody(
                description = "New colour for the brick",
                content = [Content(
                    mediaType = "application/json",
                    schema = Schema(type = "string", example = "red"),
                )]
        ) colour: String
    ): ResponseEntity<Unit> {
        legoService.setColour(brickId, colour)
        return ResponseEntity.accepted().build()
    }

    @Operation(summary = "Get a colour of a brick", description = "Returns a brick colour")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Successful Operation"),
            ApiResponse(responseCode = "404", description = "Such a brick does not exist"),

        ]
    )
    @GetMapping("/colour/{brickId}")
    fun getBrickColour(@PathVariable brickId: Int): ResponseEntity<String> =
        legoService.getBrick(brickId)?.colour?.let { ok(it) }
            ?: throw IllegalArgumentException("Brick not found")

}