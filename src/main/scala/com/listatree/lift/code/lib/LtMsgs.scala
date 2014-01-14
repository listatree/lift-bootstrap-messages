package com.listatree.lift.code.lib

import net.liftweb.http.TransientRequestVar

import scala.collection.mutable.ArrayBuffer

object LtMsgs {

 	private object messages extends TransientRequestVar(ArrayBuffer[(String, String, String)]())

 	def success(id: String, message: String) : Unit = saveMessage(id, "success", message)

 	def info(id: String, message: String) : Unit = saveMessage(id, "info", message)

 	def warning(id: String, message: String) : Unit = saveMessage(id, "warning", message)

 	def danger(id: String, message: String) : Unit = saveMessage(id, "danger", message)

	def messagesForSuccess(id: String) = messagesByIdAndLevel(id, "success")

	def messagesForInfo(id: String) = messagesByIdAndLevel(id, "info")

	def messagesForWarning(id: String) = messagesByIdAndLevel(id, "warning")

	def messagesForDanger(id: String) = messagesByIdAndLevel(id, "danger")

	private def saveMessage(id: String, level: String, message: String) : Unit = 
		messages += ((id, level, message))

	private def messagesByIdAndLevel(messagesId: String, messagesLevel: String) =
		for ((id, level, msg) <- messages.is
				if id == messagesId && level == messagesLevel)
			yield (msg)

}
