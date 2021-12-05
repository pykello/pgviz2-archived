package net.moshayedi.pgviz.visualizers

class VisualizerConfig(displayName: String) {
  var value: String = ""
}

trait VisualizerParameters {
  val parameters: Seq[VisualizerConfig]
}

trait Visualizer[P <: VisualizerParameters] {
  def name: String
  def visualize(params: P): Unit
}
