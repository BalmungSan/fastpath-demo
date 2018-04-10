package demo

import com.sksamuel.scapegoat.Inspection
import io.github.lukehutch.fastclasspathscanner.FastClasspathScanner
import io.github.lukehutch.fastclasspathscanner.matchprocessor.SubclassMatchProcessor

object Main extends App {
  println("Hello World!") // Tradition Matters!!

  val inspectionClass = classOf[Inspection]
  val fastCPScanner = new FastClasspathScanner(inspectionClass.getPackage.getName)
  var count = 0
  println("\n-------------------------------------------------------------------------------")

  fastCPScanner
    .matchSubclassesOf(
      inspectionClass,
      new SubclassMatchProcessor[Inspection] {
        override def processMatch(matchingClass: Class[_ <: Inspection]): Unit = {
          val inspection = matchingClass.newInstance()
          println(s"Mathed Class: ${matchingClass.getName}")
          println(s"Inspection name: ${inspection.text}")
          println(s"Inspection default level: ${inspection.defaultLevel}")
          println(s"Inspection explanation ${inspection.explanation.getOrElse("No Explanation")}")
          println("-------------------------------------------------------------------------------")
          count += 1
        }
      }
    ).scan()

  println(s"\n=> Matched a total of ${count} inspections (classes)!!")
}
