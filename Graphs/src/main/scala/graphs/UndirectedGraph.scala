package graphs

class UndirectedGraph[A](adjList: Map[A, List[A]]) extends DirectedGraph[A](adjList.toList) {

  override def addEdge(a: A, b: A): Graph[A] = {
    val aNeighbours = b +: neighbours(a)
    val bNeighbours = a +: neighbours(b)
    new UndirectedGraph[A](adjList + (a -> aNeighbours, b -> bNeighbours))
  }
}
