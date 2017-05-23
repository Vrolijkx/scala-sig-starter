package be.aca.scala.session1.demo


object Scopes {

  def outerFunction(data: List[String]): Boolean = {
    //I can nest a class in a function
    class ClassInFunction(classInput: String)

    //I can nest a function in function
    def innerFunction(input: String) = {
      //You can automatic acces to the parent scope
      data.contains(input.toLowerCase)
    }

    //I can even nest an object in a function
    object InnerObject

    data.forall(innerFunction)
  }


  object InnerObject


}

