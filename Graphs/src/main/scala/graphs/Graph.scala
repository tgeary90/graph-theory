package graphs

trait Graph[A] {

  def vertices: List[A]

  def edges: List[(A, A)]

  def addEdge(a: A, b: A): Graph[A]

  def neighbours(a: A): List[A]

  override def toString: String = edges.map { case (a, b) => s"$b -> $a" }.toString
}

object Graph {
  def apply[A](adjList: Map[A, List[A]]): Graph[A] = new UndirectedGraph[A](adjList)
  def apply[A](): Graph[A] = new UndirectedGraph[A](Map.empty)
}