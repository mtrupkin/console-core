package me.mtrupkin.console

/**
 * Created by mtrupkin on 12/13/2014.
 */

trait Console {
  def size: Size

  // consume input
  def input(): Option[Input]

  // draw screen to console
  def draw(screen: Screen)
}

