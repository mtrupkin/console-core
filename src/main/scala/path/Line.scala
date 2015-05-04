package me.mtrupkin.path

import me.mtrupkin.core.Point

/**
 * Created by mtrupkin on 4/23/2015.
 */
object Line {
  /**
   * Uses the Bresenham Algorithm to calculate all points on a line from p0 to p1.
   * The iterator returns all points in the interval [start, end).
   * @return the iterator containing all points on the line
   */
  def bresenham(p1: Point, p0: Point): Iterator[Point] = {
    import scala.math.abs
    val d = Point(abs(p1.x - p0.x), abs(p1.y - p0.y))

    val sx = if (p0.x < p1.x) 1 else -1
    val sy = if (p0.y < p1.y) 1 else -1

    new Iterator[Point] {
      var p = p0
      var err = d.x - d.y

      def next = {
        val e2 = 2 * err
        if (e2 > -d.y) {
          err -= d.y
          p = p.copy(x = p.x + sx)
        }
        if (e2 < d.x) {
          err += d.x
          p = p.copy(y = p.y + sy)
        }
        p
      }
      def hasNext = !(p == p1)
    }
  }
}
