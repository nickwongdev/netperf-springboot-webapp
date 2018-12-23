package com.nickwongdev.netperf.springboot.model

import com.fasterxml.jackson.annotation.JsonCreator
import java.util.*

data class WorkRequest @JsonCreator constructor(val id: UUID = UUID.randomUUID(), var content: String)
data class WorkResponse @JsonCreator constructor(val id: UUID = UUID.randomUUID(), var content: String)
