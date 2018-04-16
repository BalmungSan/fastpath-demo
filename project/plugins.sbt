addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.14.6")

//adding the generation task dependencies
libraryDependencies ++= Seq(
  "com.sksamuel.scapegoat" %% "scalac-scapegoat-plugin" % "1.3.4",
  "io.github.lukehutch" % "fast-classpath-scanner" % "2.18.1"
)
