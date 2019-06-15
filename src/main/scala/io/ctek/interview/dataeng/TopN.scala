package io.ctek.interview.dataeng

import scala.collection.SortedSet

class TopN {

  def findTopN(n: Int)(stream: Stream[Int]): List[Int] = {


    @scala.annotation.tailrec
    def findTop(stream: Stream[Int], currentTop: SortedSet[Int]): List[Int] = {
      stream match {
        case Stream.Empty =>
          currentTop.toList.reverse
        case head #:: tail => {
          val newTop = currentTop + head
          val updatedTop = if (newTop.size > n) {
            val min = newTop.min
            newTop - min
          } else {
            newTop
          }
          findTop(tail, updatedTop)
        }
      }
    }

    findTop(stream, SortedSet[Int]())

  }

}

