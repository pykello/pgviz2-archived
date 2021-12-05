package net.moshayedi.pgviz.swingui

import net.moshayedi.pgviz.visualizers.graphics.{Brush, Canvas, ColorBrush}

import java.awt.{Color, Font, Paint}
import scala.swing.Graphics2D

class SwingCanvas(graphics2D: Graphics2D) extends Canvas {
  graphics2D.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16))


  def useBrush(): Unit = {
    val p: Paint = brush match {
      case ColorBrush(r, g, b) => new Color(r, g, b)
    }
    graphics2D.setPaint(p)
  }

  def usePen(): Unit = {
    val p: Paint = pen match {
      case ColorBrush(r, g, b) => new Color(r, g, b)
    }
    graphics2D.setPaint(p)
  }

  override def drawRect(x: Int, y: Int, w: Int, h: Int): Unit = {
    useBrush()
    graphics2D.fillRect(x, y, w, h)
    usePen()
    graphics2D.drawRect(x, y, w, h)
  }

  override def drawText(s: String, x: Int, y: Int): Unit = {
    usePen()
    val metrics = graphics2D.getFontMetrics
    val y2 = y - metrics.getHeight() / 2 + metrics.getAscent()
    graphics2D.drawString(s, x, y2)
  }
}
