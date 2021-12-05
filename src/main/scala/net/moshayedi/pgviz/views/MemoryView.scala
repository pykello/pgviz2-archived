package net.moshayedi.pgviz.views

import net.moshayedi.pgviz.visualizers.graphics._

class CellGroup(startAddress: Int, values: Seq[String], color: Brush) {
  def onClick() : Unit = {
    /* by default, do nothing */
  }
}

class MemoryView(cellGroups: Seq[CellGroup],
                 size: Int = 4096,
                 perRow: Int = 32,
                 legend: Seq[(String, Brush)] = Seq()) extends View {
  def draw(canvas: Canvas): Unit = {
    drawLegend(canvas)
  }

  def drawLegend(canvas: Canvas): Unit = {
    for ((legendItem, idx) <- legend.zipWithIndex) {
      val (label: String, brush: Brush) = legendItem
      val x = 50 + (200 * (idx / 2))
      val y = 20 + (30 * (idx % 2))
      canvas.setBrush(brush)
      canvas.drawRect(x, y, 20, 20)
      canvas.drawText(label, x + 25, y + 10)
    }
  }
}
