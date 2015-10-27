package org.mtrupkin.console

import org.mtrupkin.console.Colors._

/**
 * Created by mtrupkin on 12/14/2014.
 */
case class ScreenChar(c: Char, fg: RGB = White, bg: RGB = Black)

object ScreenChar {
  implicit def CharToSc(c: Char): ScreenChar = ScreenChar(c)
  implicit def ScToChar(sc: ScreenChar): Char = sc.c
  implicit def ScToString(sc: ScreenChar): String = sc.c.toString
}