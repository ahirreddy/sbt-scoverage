name := "sbt-scoverage"

organization := "com.databricks.scoverage"

sbtPlugin := true

scalacOptions := Seq("-unchecked", "-deprecation", "-feature", "-encoding", "utf8")

scalaVersion := "2.10.5"

resolvers ++= {
  if (isSnapshot.value) Seq(Resolver.mavenLocal, Resolver.sonatypeRepo("snapshots"))
  else Seq.empty
}

libraryDependencies += "com.databricks.scoverage" %% "scalac-scoverage-plugin" % "1.1.1-1"

publishMavenStyle := true

publishArtifact in Test := false

ScriptedPlugin.scriptedSettings

scriptedLaunchOpts ++= Seq(
  "-Xmx1024M", "-XX:MaxPermSize=256M",
  "-Dplugin.version=" + version.value
)

releaseSettings

publishTo := Some("Databricks Repository on S3" at "s3://s3.amazonaws.com/databricks-mvn/release")


pomExtra := {
  <url>https://github.com/scoverage/sbt-scoverage</url>
    <licenses>
      <license>
        <name>Apache 2</name>
        <url>http://www.apache.org/licenses/LICENSE-2.0</url>
        <distribution>repo</distribution>
      </license>
    </licenses>
    <scm>
      <url>git@github.com:scoverage/sbt-scoverage.git</url>
      <connection>scm:git@github.com:scoverage/sbt-scoverage.git</connection>
    </scm>
    <developers>
      <developer>
        <id>sksamuel</id>
        <name>sksamuel</name>
        <url>http://github.com/sksamuel</url>
      </developer>
    </developers>
}
