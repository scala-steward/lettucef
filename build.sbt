ThisBuild / version := "0.0.1-SNAPSHOT"
ThisBuild / licenses := Seq("APL2" -> url("http://www.apache.org/licenses/LICENSE-2.0.txt"))
ThisBuild / organization := "dev.naoh"
ThisBuild / homepage := Some(url("https://github.com/naoh87/lettucef"))
ThisBuild / scmInfo  := Some(ScmInfo(url("https://github.com/naoh87/lettucef"), "scm:git@github.com:naoh87/lettucef.git"))
ThisBuild / versionScheme := Some("semver-spec")


val scala213 = "2.13.7"
val scala310 = "3.1.0"

lazy val root = (project in file("."))
  .settings(
    crossScalaVersions := Nil,
    publishArtifact := false
  )
  .aggregate(core)

lazy val core = (project in file("core")).settings(
  name := "lettucef-core",
  scalaVersion := scala213,
  crossScalaVersions := Seq(scala213, scala310),
  Test / fork := true,
  libraryDependencies ++= Seq(
    "io.lettuce" % "lettuce-core" % "6.1.5.RELEASE",
    "org.typelevel" %% "cats-effect" % "3.3.1",
    "co.fs2" %% "fs2-core" % "3.2.4",
    "org.scalatest" %% "scalatest" % "3.2.10" % "test",
  ),
  publishMavenStyle := true,
  Test / publishArtifact := false,
  publishTo := {
    val nexus = "https://s01.oss.sonatype.org/"
    if (isSnapshot.value) Some("snapshots" at nexus + "content/repositories/snapshots")
    else Some("releases" at nexus + "service/local/staging/deploy/maven2")
  },
  credentials ++=
    (for {
      user <- sys.env.get("SONATYPE_USER")
      password <- sys.env.get("SONATYPE_PASSWORD")
    } yield
      Credentials(
        "Sonatype Nexus Repository Manager",
        "s01.oss.sonatype.org",
        user,
        password
      )).toList
)

val circeVersion = "0.14.1"
lazy val codegen = (project in file("codegen")).settings(
  name := "lettucef-codegen",
  scalaVersion := scala213,
  run / fork := true,
  libraryDependencies ++= Seq(
    "org.typelevel" %% "cats-effect" % "3.3.1",
    "org.typelevel" %% "cats-parse" % "0.3.6",
    "io.circe" %% "circe-yaml" % "0.14.1",
    "co.fs2" %% "fs2-core" % "3.2.4",
    "co.fs2" %% "fs2-io" % "3.2.4",
  ),
  libraryDependencies ++= Seq(
    "io.circe" %% "circe-core",
    "io.circe" %% "circe-generic",
    "io.circe" %% "circe-parser"
  ).map(_ % circeVersion)
)