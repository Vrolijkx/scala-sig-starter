package be.aca.scala.session1.demo


class ApplyUnApply(var param1: String, var param2: String) {

  def apply(): String = s"apply $param1, $param2"

}

object ApplyUnApply {

  //apply is special method an can be called
  //when the object is invoked like a function
  def apply(param1: String, param2: String): ApplyUnApply = {
    new ApplyUnApply(param1, param2)
  }

  def apply(param: String): ApplyUnApply = {
    new ApplyUnApply(param, param)
  }

  //Unapply is used with destructuring and pattern matching
  def unapply(arg: ApplyUnApply): Option[(String, String)] = {
    Some((arg.param1, arg.param2))
  }
}

