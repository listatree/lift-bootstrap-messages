package com.listatree.lift.code.snippet

import net.liftweb.util._
import net.liftweb.util.Helpers._
import net.liftweb.common._

import net.liftweb.http._
import net.liftweb.http.js._
import net.liftweb.http.js.JsCmds._
import net.liftweb.http.js.JE._

import scala.xml._

import com.listatree.lift.code.lib.LtMsgs

object LtFormSample {
 
	def render = {
		var email = ""
		var password = ""

		def process() = {
			LtMsgs.danger("global", "Template sample")
			LtMsgs.success("login", "Local sample for email " + email)
			LtMsgs.success("login", "Another local sample")
			LtMsgs.warning("login", "Warning local sample")
		}

		"name=login_email" #> SHtml.onSubmit(email = _) &
		"name=login_password" #> SHtml.onSubmit(password = _) &
		"type=submit" #> SHtml.onSubmitUnit(process)
	}
 
}
