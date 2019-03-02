package navitech.tellem.dsl

import org.scalatest._

import navitech.tellem.dsl.TellemSyntax._

class TellemDslSpec extends FlatSpec with Matchers {

  implicit val in: TellemInput = TellemInput("""{"foo": "bar"}""")

  "an input" should "parse" in {

    val strOpt = "$.somepath".str

    strOpt should not be 'defined

    val intOpt = "$.somepath".int

    intOpt should not be 'defined

    val dblOpt = "$.somepath".dbl

    dblOpt should not be 'defined

  }

}
