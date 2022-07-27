package graphs

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class GraphSpec extends AnyFlatSpec with Matchers {

  "Graph" should "print edges" in {
    val g = Graph[String]()
      .addEdge("A", "B")
      .addEdge("B", "C")
      .addEdge("C", "E")
      .addEdge("C", "D")
      .addEdge("A", "G")
      .addEdge("G", "H")
      .addEdge("E", "C")

    println(g)
    println(g.vertices.size)
  }
}
