name := """console-core"""

scalaVersion := "2.11.4"

organization := "me.mtrupkin"

licenses += ("MIT", url("http://www.opensource.org/licenses/mit-license.html"))

bintraySettings

releaseSettings

repository in bintray := "maven"

bintrayOrganization in bintray := None

libraryDependencies += "org.scalatest" %% "scalatest" % "2.1.6" % "test"

libraryDependencies += "com.typesafe.play" %% "play-json" % "2.4.0-M2"
