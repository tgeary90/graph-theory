package graphs

object Traversal {
  def traversalDFS[A](start: A, graph: Graph[A], f: A => Unit, visited: Set[A]): Set[A] = {
    if (visited.contains(start)) visited
    else {
      f(start)
      graph.neighbours(start).foldLeft(visited + start)((allVisited, n) => traversalDFS(n, graph, f, allVisited))
    }
  }

  def traversalDFS[A](start: A, graph: Graph[A], f: A => Unit): Unit = {
    Stream.iterate((List(start), Set[A](start))) { case (stk, visited) => {
      val vertex = stk.head
      val newStack = graph.neighbours(vertex).filterNot(visited.contains) ++ stk.tail
      val newVisited = graph.neighbours(vertex).toSet ++ visited
      (newStack, newVisited)
    }}.takeWhile { case (t1, _) => t1.nonEmpty }.foreach(t => f(t._1.head))
  }
}
