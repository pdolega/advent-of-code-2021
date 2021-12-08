name := "scala3"
version := "0.1"
scalaVersion := "3.1.0"

resolvers += ("Artima Maven Repository" at "http://repo.artima.com/releases").withAllowInsecureProtocol(true)

Test / logBuffered := false


libraryDependencies ++= Seq(
  "org.scalactic" %% "scalactic" % "3.2.10",
  "org.scalatest" %% "scalatest" % "3.2.10" % Test
)