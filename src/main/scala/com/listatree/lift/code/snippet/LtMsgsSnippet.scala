package com.listatree.lift.code.snippet

import scala.xml._

import net.liftweb.common.Full
import net.liftweb.http.S
import net.liftweb.util.Helpers._

import com.listatree.lift.code.lib.LtMsgs

object LtMsgsSnippet {


	def render = {
		
		val messagesId = S.attr("id").openOr("default")

		val successMsgs = LtMsgs.messagesForSuccess(messagesId)
	
		val infoMsgs = LtMsgs.messagesForInfo(messagesId)

		val warningMsgs = LtMsgs.messagesForWarning(messagesId)

		val dangerMsgs = LtMsgs.messagesForDanger(messagesId)

		val processSuccessMsgs = ".alert .alert-success" #> (successMsgs map (".msg *" #> _))

		val processInfoMsgs = ".alert .alert-info" #> (infoMsgs map (".msg *" #> _))

		val processWarningMsgs = ".alert .alert-warning" #> (warningMsgs map (".msg *" #> _))

		val processDangerMsgs = ".alert .alert-danger" #> (dangerMsgs map (".msg *" #> _))

		processSuccessMsgs &
		processInfoMsgs &
		processWarningMsgs &
		processDangerMsgs

	}

}
