import graphs.{Graph, Traversal}

val g = Graph[String]()
  .addEdge("A", "B")
  .addEdge("B", "C")
  .addEdge("C", "E")
  .addEdge("C", "D")
  .addEdge("A", "G")
  .addEdge("G", "H")
  .addEdge("C", "D")


Traversal.traversalDFS[String]("A", g, str => println(str))
Traversal.traversalDFS[String]("A", g, str => println(str), Set.empty[String])


println(g)

val g2 = Graph[Int]().addEdge(1, 2).addEdge(7, 2).addEdge(1, 14)
println(g2)