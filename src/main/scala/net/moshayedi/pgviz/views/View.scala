package net.moshayedi.pgviz.views

import net.moshayedi.pgviz.visualizers.graphics.Canvas

trait View {
  def draw(canvas: Canvas): Unit
}
