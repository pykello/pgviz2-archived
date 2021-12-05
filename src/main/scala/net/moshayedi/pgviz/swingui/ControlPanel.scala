package net.moshayedi.pgviz.swingui

import scala.swing._
import scala.swing.event.ButtonClicked

class ControlPanel extends BoxPanel(orientation = Orientation.Vertical) {
  val connectButton = new Button("Connect")
  contents += connectButton

  listenTo(connectButton)
  reactions += {
    case ButtonClicked(`connectButton`) =>
      println(ConnectionStringDialog.getConnectionString)
  }

}

class ConnectionStringDialog extends Dialog {
  val connect = new Button("Connect")
  val cancel = new Button("Cancel")

  modal = true
  resizable = false
  centerOnScreen()
  defaultButton = connect
  var connectionString: Option[String] = None

  val hostname = new TextField("localhost")
  val port = new TextField("5432")
  val user = new TextField("hadi")
  val database = new TextField("postgres")


  contents = new GridPanel(rows0=5, cols0=2) {
    contents += new Label("hostname:")
    contents += hostname
    contents += new Label("port:")
    contents += port
    contents += new Label("user:")
    contents += user
    contents += new Label("database:")
    contents += database
    contents += connect
    contents += cancel
  }

  listenTo(connect)
  listenTo(cancel)

  reactions += {
    case ButtonClicked(`connect`) =>
      connectionString = Some(s"postgresql://${user.text}@${hostname.text}:${port.text}/${database.text}")
      this.close()
    case ButtonClicked(`cancel`) =>
      connectionString = None
      this.close()
  }
}

object ConnectionStringDialog {
  def getConnectionString: Option[String] = {
    val dlg = new ConnectionStringDialog()
    dlg.open()
    dlg.connectionString
  }
}