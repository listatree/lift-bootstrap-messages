name := "lift-bootstrap-messages"

version := "1.0.0"

organization := "com.listatree"

scalaVersion := "2.10.3"

resolvers ++= Seq(
  "Java.net Maven2 Repository"     at "http://download.java.net/maven/2/",
  "Sonatype scala-tools repo"      at "https://oss.sonatype.org/content/groups/scala-tools/",
  "Sonatype scala-tools staging"   at "http://oss.sonatype.org/content/repositories/staging",
  "Sonatype scala-tools releases"  at "https://oss.sonatype.org/content/repositories/releases",
  "Sonatype scala-tools snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
)

seq(com.github.siasia.WebPlugin.webSettings :_*)

unmanagedResourceDirectories in Test <+= (baseDirectory) { _ / "src/main/webapp" }

scalacOptions ++= Seq("-deprecation", "-unchecked")

{
  val liftVersion = "2.5.1"
  libraryDependencies ++= Seq(
    "net.liftweb"             %% "lift-webkit"       % liftVersion             % "compile",
    "org.eclipse.jetty"       %  "jetty-webapp"      % "8.1.7.v20120910"       %  "container,compile",
    "org.eclipse.jetty.orbit" %  "javax.servlet"     % "3.0.0.v201112011016"   %  "container,compile" artifacts Artifact("javax.servlet", "jar", "jar"),
    "ch.qos.logback"          %  "logback-classic"   % "1.0.6",
    "org.specs2"              %% "specs2"            % "1.14"                  % "test"
  )
}

EclipseKeys.withSource := true

EclipseKeys.relativizeLibs := false
