package net.moshayedi.pgviz.visualizers

class HeapParameters extends VisualizerParameters {
  val relationName = new VisualizerConfig("Relation Name")
  val pageIndex = new VisualizerConfig("Page Index")
  override val parameters: Seq[VisualizerConfig] = Seq(relationName, pageIndex)
}

class HeapVisualizer extends Visualizer[HeapParameters] {
  override def name: String = "Heap Page"

  override def visualize(params: HeapParameters): Unit = {
    // todo
  }
}
