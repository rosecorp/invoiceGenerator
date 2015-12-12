
name := "invoiceGenerator"

version := "1.0"

scalaVersion := "2.11.7"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

assemblyJarName in assembly := "invoicer.jar"

//To skip the test during assembly
test in assembly := {}
mainClass in assembly := Some("com.seon.invoicer.GeneratePdf")

libraryDependencies ++= {
  val akkaV = "2.3.9"
  val sprayV = "1.3.3"
  Seq(
    "io.spray"            %%  "spray-can"     % sprayV,
    "io.spray"            %%  "spray-routing" % sprayV,
    "io.spray"            %%  "spray-testkit" % sprayV  % "test",
    "io.spray"            %    "spray-json_2.11"   % "1.3.1",
    "com.typesafe.akka"   %%  "akka-actor"    % akkaV,
    "com.typesafe.akka"   %%  "akka-testkit"  % akkaV   % "test",
    "org.specs2"          %%  "specs2-core"   % "2.3.11" % "test",
    "org.xhtmlrenderer"   %   "flying-saucer-core" % "9.0.8",
    "org.xhtmlrenderer"   % "flying-saucer-pdf" % "9.0.8",
    "com.typesafe.play" %%    "play-json"     % "2.4.2"
  )
}
