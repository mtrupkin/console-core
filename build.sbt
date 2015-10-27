import bintray.Keys._

name := """console-core"""

scalaVersion := "2.11.7"

organization := "org.mtrupkin.console"

licenses += ("MIT", url("http://www.opensource.org/licenses/mit-license.html"))

bintraySettings

releaseSettings

publishMavenStyle := false

repository in bintray := "ivy"

bintrayOrganization in bintray := None
