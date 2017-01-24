name := "MultiProjects"

version := "1.0"

lazy val model = project in file("model")
lazy val `multiprojects` = (project in file(".")).enablePlugins(PlayScala).dependsOn(model)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
//    cache ,
//    ws,
//    specs2 % Test,
    "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.0-RC1" % Test,
    "com.typesafe.slick" %% "slick" % "3.1.1",
    "com.typesafe.play" %% "play-slick" % "1.1.1",
    "com.typesafe.play" %% "play-slick-evolutions" % "1.1.1",
    "mysql" % "mysql-connector-java" % "5.1.38",
    "org.slf4j" % "log4j-over-slf4j" % "1.7.21",
    "joda-time" % "joda-time" % "2.9.3"
)

//unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"  