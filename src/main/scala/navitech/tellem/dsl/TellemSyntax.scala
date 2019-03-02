package navitech.tellem.dsl

object TellemSyntax extends TellemSyntax {}

trait TellemSyntax {

  implicit class pathToString(path: String)(implicit input: TellemInput) {
    def str: Option[String] = None
    def int: Option[Int] = None
    def dbl: Option[Double] = None
  }

}
