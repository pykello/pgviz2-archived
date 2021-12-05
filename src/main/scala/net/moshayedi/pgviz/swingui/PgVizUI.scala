package net.moshayedi.pgviz.swingui

import scala.swing._

class PgVizUI extends MainFrame {
  title = "GUI Program #1"
  preferredSize = new Dimension(1024, 1024)
  contents = new BoxPanel(orientation = Orientation.Vertical) {
    contents += new ControlPanel
    xLayoutAlignment = 0
  }
}
