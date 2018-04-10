name := "fastpath-demo"
version := "1.0.0"
scalaVersion := "2.12.5"

libraryDependencies ++= Seq(
  "com.sksamuel.scapegoat" %% "scalac-scapegoat-plugin" % "1.3.4",
  "io.github.lukehutch" % "fast-classpath-scanner" % "2.18.1"
)
