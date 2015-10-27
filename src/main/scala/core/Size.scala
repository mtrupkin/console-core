package org.mtrupkin.core

/**
 * Created by mtrupkin on 12/14/2014.
 */
case class Size(width: Int, height: Int) {
  def add(s: Size): Size = Size(this.width + s.width, this.height + s.height)
  def subtract(s: Size): Size = Size(this.width - s.width, this.height - s.height)

  def in(p: Point): Boolean = (p.x >= 0 && p.y >= 0 && p.x < width && p.y < height)

  def foreach(f: (Point => Unit)): Unit = {
    for {
      x <- 0 until width
      y <- 0 until height
    } f(x, y)
  }

  def neighbors(p: Point, r: Int = 1): Seq[Point] = {
    for {
      x <- -r to r
      y <- -r to r
      if !((x == 0) && (y == 0))
      p0 = p + (x, y)
      if in(p0)
    } yield p0
  }
}

object Size {
  implicit def DoubleTupleToSize(t: (Double, Double)): Size = Size(t._1.toInt, t._2.toInt)
  implicit def TupleToSize(t: (Int, Int)): Size = Size(t._1, t._2)
  implicit def SizeToTuple(s: Size): (Int, Int) = (s.width, s.height)
}

object Sizes {
  val ZERO = new Size(0, 0)
  val ONE = new Size(1, 1)
}
