name := "model"

version := "1.0-SNAPSHOT"

scalaVersion := "2.11.7"

lazy val model = project in file(".")

libraryDependencies ++= Seq(
    "com.typesafe" % "config" % "1.3.0",
    "com.typesafe.slick" %% "slick" % "3.1.1",
    "com.typesafe.slick" %% "slick-codegen" % "3.1.1",
    "mysql" % "mysql-connector-java" % "5.1.38"
)