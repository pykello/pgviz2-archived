package net.moshayedi.pgviz.visualizers.graphics

/* paint, brush, ... abstraction */
trait Brush {

}

case class ColorBrush(r: Float, g: Float, b: Float) extends Brush;

/* graphics abstraction */
trait Canvas {
  var pen: ColorBrush = ColorBrush(0, 0, 0)
  var brush: Brush = ColorBrush(1.0f, 1.0f, 1.0f)

  def setBrush(brush: Brush) = this.brush = brush
  def setPen(color: ColorBrush) = this.pen = pen

  def drawRect(x: Int, y: Int, w: Int, h: Int)
  def drawText(s: String, x: Int, y: Int)
}
