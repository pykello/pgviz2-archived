package net.moshayedi.pgviz

import net.moshayedi.pgviz.swingui.PgVizUI

object PgVizApp extends App {
  val ui = new PgVizUI
  ui.visible = true
  println("End of main function")
}
