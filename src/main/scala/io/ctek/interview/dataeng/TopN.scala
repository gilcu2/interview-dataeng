package io.ctek.interview.dataeng

class TopN {

  def findTopN(n: Int)(stream: Stream[Int]): List[Int] = {
    val container = collection.mutable.SortedSet[Int]()
    stream.foreach(element=>{
      container+=element
      if(container.size>n)
        container.remove(container.min)
    })
    container.toList.reverse
  }

}

