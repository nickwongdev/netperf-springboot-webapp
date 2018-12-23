package com.nickwongdev.netperf.springboot.controller

import com.nickwongdev.netperf.springboot.model.WorkRequest
import com.nickwongdev.netperf.springboot.model.WorkResponse
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class WorkController {

    @PostMapping("/work")
    fun work(@RequestBody workRequest: WorkRequest): WorkResponse {
        return WorkResponse(UUID.randomUUID(), workRequest.content)
    }
}