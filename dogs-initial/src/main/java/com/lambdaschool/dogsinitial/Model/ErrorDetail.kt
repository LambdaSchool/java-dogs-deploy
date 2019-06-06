package com.lambdaschool.dogsinitial.Model

import com.lambdaschool.dogsinitial.Exception.ValidationError
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.HashMap

class ErrorDetail(val title: String,
                  val status: Int,
                  val detail: String,
                  val timestamp: Timestamp,
                  val developerMessage: String)
