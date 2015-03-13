package me.mtrupkin.console

import me.mtrupkin.console.Colors._
import me.mtrupkin.core.{Points, Point, Size}

/**
 * Created by mtrupkin on 12/13/2014.
 */

class Screen(val size: Size) {
  val blank: ScreenChar = ScreenChar(' ')
  var fg: RGB = White
  var bg: RGB = Black

  val buffer = Array.ofDim[ScreenChar](size.width, size.height)
  clear()

  def apply(p: Point): ScreenChar = buffer(p.x)(p.y)
  def update(p: Point, sc: ScreenChar): Unit = if(size.in(p)) buffer(p.x)(p.y) = sc

  def write(p: Point, sc: ScreenChar): Unit = this(p) = sc
  def write(p: Point, c: Char): Unit = this(p) = ScreenChar(c, fg, bg)
  def write(s: String): Unit = write(Points.Origin, s)
  def write(p: Point, s: String): Unit = {
    var pos = p.x
    s.foreach( c => { write(Point(pos, p.y), c); pos += 1 } )
  }

  def foreach(f: (Point, ScreenChar) => Unit ): Unit = size.foreach(p => f(p,this(p)))

  def clear() = foreach((p, s) => this(p) = blank)
  def clear(p: Point) = this(p) = blank

  def transform(f: (ScreenChar) => ScreenChar ): Unit = size.foreach(p => this(p) = f(this(p)))
}

object Screen {
  def apply(size: Size): Screen = new Screen(size)
}

class SubScreen(val origin: Point, val screen: Screen, size: Size) extends Screen(size) {
  override def update(p: Point, sc: ScreenChar) = screen.update(origin + p, sc)
  override def apply(p: Point): ScreenChar = screen(origin + p)
}
