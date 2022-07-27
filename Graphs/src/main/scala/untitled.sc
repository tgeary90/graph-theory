import graphs.Graph

val g = Graph[String]()
  .addEdge("London", "Lisbon")
  .addEdge("Rome", "Barcelona")

println(g)
println(g.vertices)
println(g.neighbours("London"))


