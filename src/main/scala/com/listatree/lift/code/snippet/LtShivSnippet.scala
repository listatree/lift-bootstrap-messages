package com.listatree.lift.code.snippet

import net.liftweb.util.Helpers._
import scala.xml._

class LtShivSnippet {

	def render = Unparsed("""
   		<!--[if lt IE 9]>
      		<script src="js/html5shiv.js"></script>
      		<script src="js/respond.js"></script>
    	<![endif]-->
    """)

  

}
