package navitech.tellem.dsl

object TellemSyntax extends TellemSyntax {}

trait TellemSyntax {

  implicit class pathToString(path: String) {
    def str: String = ""
  }

}
