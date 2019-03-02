name := "TellemDsl"

organization := "tech.navicore"

fork := true
javaOptions in test ++= Seq(
  "-Xms128M", "-Xmx256M",
  "-XX:MaxPermSize=256M",
  "-XX:+CMSClassUnloadingEnabled"
)

scalacOptions += "-Ypartial-unification"

parallelExecution in test := false

version := "1.0"

scalaVersion := "2.12.8"
val scala211 = "2.11.12"
val scala212 = "2.12.8"

crossScalaVersions := Seq(scala211, scala212)

homepage := Some(url("https://github.com/navicore/tellem-dsl"))

scmInfo := Some(ScmInfo(url("https://github.com/navicore/tellem-dsl"),
                            "git@github.com:navicore/tellem-dsl.git"))

developers := List(Developer("navicore",
                             "Ed Sweeney",
                             "ed@onextent.com",
                             url("https://github.com/navicore")))
licenses += ("MIT", url("https://opensource.org/licenses/MIT"))

import ReleaseTransformations._

releaseCrossBuild := true

releasePublishArtifactsAction := PgpKeys.publishSigned.value // Use publishSigned in publishArtifacts step

releaseProcess := Seq[ReleaseStep](
  checkSnapshotDependencies,
  inquireVersions,
  runClean,
  runTest,
  setReleaseVersion,
  commitReleaseVersion,
  tagRelease,
  publishArtifacts,
  setNextVersion,
  commitNextVersion,
  releaseStepCommand("sonatypeReleaseAll"),
  pushChanges
)


sonatypeProfileName := "tech.navicore"
useGpg := true
publishTo := Some(
  if (isSnapshot.value)
    Opts.resolver.sonatypeSnapshots
  else
    Opts.resolver.sonatypeStaging
)

libraryDependencies ++=
  Seq(

    "ch.qos.logback" % "logback-classic" % "1.2.3",
    "com.typesafe" % "config" % "1.3.3",
    "com.typesafe.scala-logging" %% "scala-logging" % "3.9.2",

    "org.scalatest" %% "scalatest" % "3.0.5" % "test"

  )

mainClass in assembly := Some("navitech.tellem.dsl.Main")
assemblyJarName in assembly := "TellemDsl.jar"

assemblyMergeStrategy in assembly := {
  case PathList("reference.conf") => MergeStrategy.concat
  case x if x.endsWith("io.netty.versions.properties") => MergeStrategy.first
  case PathList("META-INF", _ @ _*) => MergeStrategy.discard
  case _ => MergeStrategy.first
}

