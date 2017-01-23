name := "MultiProjects"

version := "1.0"

lazy val model = project in file("model")
lazy val `multiprojects` = (project in file(".")).enablePlugins(PlayScala).dependsOn(model)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
    cache ,
    ws,
    "com.typesafe.slick" %% "slick" % "3.1.1",
    "com.typesafe.play" %% "play-slick" % "1.1.1",
    "com.typesafe.play" %% "play-slick-evolutions" % "1.1.1",
    "mysql" % "mysql-connector-java" % "5.1.38"
)

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )  

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"  