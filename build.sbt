import bintray.Keys._

name := """console-core"""

scalaVersion := "2.11.6"

organization := "me.mtrupkin.console"

licenses += ("MIT", url("http://www.opensource.org/licenses/mit-license.html"))

bintraySettings

releaseSettings

publishMavenStyle := false

repository in bintray := "ivy"

bintrayOrganization in bintray := None

libraryDependencies += "org.scalatest" %% "scalatest" % "2.1.6" % "test"

libraryDependencies += "com.typesafe.play" %% "play-json" % "2.4.0-M2"
