package com.nickwongdev.netperf.springboot.controller

import com.nickwongdev.netperf.service.WorkService
import com.nickwongdev.netperf.springboot.model.WorkRequest
import com.nickwongdev.netperf.springboot.model.WorkResponse
import kotlinx.coroutines.runBlocking
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class WorkController @Autowired constructor(
	private val workService: WorkService
) {

	companion object {
		const val DEFAULT_ITERATIONS = 1;
		const val DEFAULT_CALCITERMIN = 1;
		const val DEFAULT_CALCITERMAX = 2;
		const val DEFAULT_WAITMIN = 1L;
		const val DEFAULT_WAITMAX = 2L;
	}

	@PostMapping("/work")
	fun work(
		@RequestBody workRequest: WorkRequest,
		@RequestParam(required = false) iterations: Int?,
		@RequestParam(required = false) calculationsMin: Int?,
		@RequestParam(required = false) calculationsMax: Int?,
		@RequestParam(required = false) waitMin: Long?,
		@RequestParam(required = false) waitMax: Long?
	): WorkResponse {

		val iter = iterations ?: DEFAULT_ITERATIONS
		val cMin = calculationsMin ?: DEFAULT_CALCITERMIN
		val cMax = calculationsMax ?: DEFAULT_CALCITERMAX
		val wMin = waitMin ?: DEFAULT_WAITMIN
		val wMax = waitMax ?: DEFAULT_WAITMAX

		runBlocking {
			val result = workService.work(iter, cMin, cMax, wMin, wMax)
			println("Work Calculations: $result")
		}
		return WorkResponse(UUID.randomUUID(), workRequest.content)
	}
}