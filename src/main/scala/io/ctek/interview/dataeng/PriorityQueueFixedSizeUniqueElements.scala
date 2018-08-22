//package io.ctek.interview.dataeng
//
//case class FindResult(finded:Boolean,node:Node)
//
//class Node(val value:Int,var left:Option[Node]=None,var right:Option[Node]=None) {
//
//  def find(value:Int):FindResult=(value,this.left,this.right) match {
//
//    case (_,_,_) if value == this.value=>
//      FindResult(true,this)
//
//    case (_,Some(left),_) if value < this.value  && left.value<=value =>
//      FindResult(false,this)
//
//    case (_,Some(left),_) if value < this.value  && left.value>value =>
//      left.find(value)
//
//    case (_,_,Some(right)) if value > this.value && right.value >=value =>
//      right.find(value)
//
//    case (_,_,Some(right)) if value > this.value && right.value >=value =>
//      FindResult(false,this)
//
//    case _=>
//      FindResult(false,this)
//
//  }
//
//  def add(value:Int):Node ={
//    this.find(value) match {
//      case FindResult(true,_)=>
//        this
//      case FindResult(false,node) if node.value>value=> {
//        val
//      }
//    }
//  }
//
//}
