package graphs

class DirectedGraph[A](adjList: List[(A, List[A])]) extends Graph[A] {
  override def vertices: List[A] = adjList.flatMap { case (v, nibs) => v +: nibs }.distinct

  override def edges: List[(A, A)] = {
    adjList.flatMap { case (v, nibs) => nibs.map(n => n -> v) }
  }

  override def addEdge(a: A, b: A): Graph[A] = {
    val aNeighbours = b +: neighbours(a)
    new DirectedGraph[A](adjList :+ (a -> aNeighbours))
  }

  override def neighbours(a: A): List[A] = adjList
    .find { case (v, _) => v == a }
    .map { case (_, as) => as }.getOrElse(List.empty[A])
}
