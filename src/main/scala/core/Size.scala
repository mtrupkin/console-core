package me.mtrupkin.core

/**
 * Created by mtrupkin on 12/14/2014.
 */
case class Size(width: Int, height: Int) {
  def add(s: Size): Size = Size(this.width + s.width, this.height + s.height)
  def subtract(s: Size): Size = Size(this.width - s.width, this.height - s.height)

  def inBounds(p: Point): Boolean = (p.x >= 0 && p.y >= 0 && p.x < width && p.y < height)

  def foreach(f: (Int, Int) => Unit): Unit = for ( x <- 0 until width; y <- 0 until height ) f(x, y)
}



object Sizes {
  val ZERO = new Size(0, 0)
  val ONE = new Size(1, 1)
}
