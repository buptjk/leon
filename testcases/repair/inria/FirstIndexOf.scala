import leon.lang._
import leon.collection._
import leon.lang.synthesis._


object FirstIndexOf {
  def firstIndexOf(l: List[Int], v: Int): Int = {
    l match {
      case Cons(h, t) if v == h => 0
      case Cons(h, t) =>
        if (firstIndexOf(t, v) >= 0) {
          firstIndexOf(t, v)+1
        } else {
          -1
        }
      case Nil() =>
        -1
    }
  } ensuring {
    (res: Int) => (if (l.content contains v) {
      l.size > res && l.apply(res) == v
    } else {
      res == -1
    }) && (((l,v), res) passes {
      case (Cons(0, Cons(1, Cons(2, Cons(3, Nil())))), 3) => 3
      case (Cons(0, Cons(2, Cons(3, Cons(1, Nil())))), 1) => 3
      case (Cons(0, Cons(1, Cons(3, Cons(1, Nil())))), 1) => 1
      case (Cons(0, Cons(1, Cons(3, Cons(1, Nil())))), 2) => -1
    })
  }
}
