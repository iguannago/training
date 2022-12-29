name := "exercise-from-modules"

version := "1.0"

scalacOptions ++= Seq("-deprecation")

scalaVersion := "2.11.8"

// http://mvnrepository.com/artifact/junit/junit
libraryDependencies += "junit" % "junit" % "4.12" % "test"
libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.5" % "test"



// for funsets
//libraryDependencies += "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.4"


