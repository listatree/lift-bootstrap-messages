package bootstrap.liftweb

import net.liftweb.util._
import net.liftweb.util.Helpers._

import net.liftweb.common._
import net.liftweb.http._
import net.liftweb.http.js.JE
import net.liftweb.sitemap._


/**
 * A class that's instantiated early and run.  It allows the application
 * to modify lift's environment
 */
class Boot {
  def boot {

    // where to search snippet
    LiftRules.addToPackages("com.listatree.lift.code")

    // Build SiteMap
    def sitemap = SiteMap(
      Menu.i("Home") / "index"
    )
    LiftRules.setSiteMapFunc(() => sitemap)

    //Show the spinny image when an Ajax call starts
    LiftRules.ajaxStart =
      Full(() => LiftRules.jsArtifacts.show("ajax-loader").cmd)
    
    // Make the spinny image go away when it ends
    LiftRules.ajaxEnd =
      Full(() => LiftRules.jsArtifacts.hide("ajax-loader").cmd)

    // Force the request to be UTF-8
    LiftRules.early.append(_.setCharacterEncoding("UTF-8"))

    // What is the function to test if a user is logged in?
    // LiftRules.loggedInTest = Full(() => User.loggedIn_?)

    // Use HTML5 for rendering
    LiftRules.htmlProperties.default.set((r: Req) =>
      new Html5Properties(r.userAgent))    

    // The ajaxLift.js file is used statically as recomended at
    // http://www.eltimn.com/blog/002-javascript-apps-with-lift-best-practices
    // If LiftRules change, regenerate it from /ajax_request/ajaxLift.js
    LiftRules.autoIncludeAjaxCalc.default.set(() => 
      (session: LiftSession) => false)

  }
}
