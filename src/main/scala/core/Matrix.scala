package me.mtrupkin.core

import scala.reflect.ClassTag
import scala.Array._

/**
 * Created by mtrupkin on 1/7/2015.
 */

// mutable matrix
class Matrix[T: ClassTag](val size: Size) {
  val elems = ofDim[T](size.width, size.height)
  def apply(p: Point): T = elems(p.x)(p.y)
  def update(p: Point, value: T): Unit = elems(p.x)(p.y) = value
  def foreach(f: (Point, T) => Unit) = size.foreach(p => f(p, this(p)))
}
