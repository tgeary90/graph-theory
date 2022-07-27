package graphs

case class WeightedEdge[A](destination: A, weight: Int)

class WeightedGraph[A](adjList: Map[A, List[WeightedEdge[A]]]) extends Graph[A] {
  override def vertices: List[A] = adjList.keys.toList

  override def edges: List[(A, A)] = adjList.flatMap { case (v, edgeList) => edgeList.map(e => v -> e.destination) }.toList

  def addEdge(a: A, weightedEdge: WeightedEdge[A]): WeightedGraph[A] = {
    val aNeighbours = weightedEdge +: adjList.getOrElse(a, List.empty[WeightedEdge[A]])
    new WeightedGraph[A](adjList + (a -> aNeighbours))
  }

  override def addEdge(a: A, b: A): Graph[A] = addEdge(a, new WeightedEdge[A](b, 0))

  override def neighbours(a: A): List[A] = adjList.getOrElse(a, Nil).map(_.destination)

  def neighboursWithWeights(a: A): List[WeightedEdge[A]] = adjList.getOrElse(a, Nil).toList
}
