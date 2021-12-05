import net.moshayedi.pgviz.swingui.{ControlPanel, SwingCanvas}
import net.moshayedi.pgviz.views.{MemoryView, View}
import net.moshayedi.pgviz.visualizers.graphics.ColorBrush
import org.scalatest.FunSuite

import java.awt.Color
import scala.swing._

class TestUI(view: View) extends MainFrame {
  class Drawer extends Component {
    override def paint(g: Graphics2D): Unit = {
      g.setBackground(Color.WHITE)
      g.clearRect(0, 0, 1000, 1000)
      super.paint(g)
      val canvas = new SwingCanvas(g)
      view.draw(canvas)
    }
    preferredSize = new Dimension(1024, 1024)
  }
  title = "GUI Program #1"
  contents = new Drawer
}

class ViewTestMain extends FunSuite {
  def showView(v: View): Unit = {
    val ui = new TestUI(v)
    ui.visible = true
    while (ui.visible) {
      Thread.sleep(500)
    }
  }

  test("Test MemoryView") {
    val memoryView = new MemoryView(Seq(),
      legend = Seq(
        ("Page Header", ColorBrush(1f, 0.5f, 0.5f)),
        ("ItemId", ColorBrush(0.5f, 1f, 0.5f)),
        ("ItemId", ColorBrush(0.5f, 0.5f, 1.0f))))
    showView(memoryView)
  }
}
