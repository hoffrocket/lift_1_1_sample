import sbt._

class MyProject(info: ProjectInfo) extends DefaultWebProject(info) {
  val liftSnapshotsRepo = "scala snapshots repository" at "http://scala-tools.org/repo-snapshots"
  
  val liftVersion = "2.0-SNAPSHOT"
  
  val liftMapper = "net.liftweb" % "lift-mapper" % liftVersion % "compile"

  val liftWebkit = "net.liftweb" % "lift-webkit" % liftVersion % "compile"
  val liftUtil = "net.liftweb" % "lift-util" % liftVersion % "compile"

  val servlet = "javax.servlet" % "servlet-api" % "2.5" % "provided"
  val jetty6 = "org.mortbay.jetty" % "jetty" % "6.1.21" % "test"
  val h2 = "com.h2database" % "h2" % "1.2.128"

  override def scanDirectories = Nil
  override def jettyWebappPath = webappPath
  
  override def jettyPort = systemOptional[Int]("jetty.port", 8080).value
 
}
