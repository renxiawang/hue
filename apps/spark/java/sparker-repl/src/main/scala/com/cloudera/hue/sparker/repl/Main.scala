package com.cloudera.hue.sparker.repl

import org.eclipse.jetty.server.Server
import org.eclipse.jetty.servlet.{ServletHolder, DefaultServlet}
import org.eclipse.jetty.webapp.WebAppContext
import org.scalatra.servlet.{AsyncSupport, ScalatraListener}

import scala.concurrent.ExecutionContext

object Main {
  def main(args: Array[String]): Unit = {
    val port = 8087
    val server = new Server(port)
    val context = new WebAppContext()

    context.setContextPath("/")
    context.setResourceBase("src/main/com/cloudera/hue/sparker/repl")
    context.addEventListener(new ScalatraListener)

    context.addServlet(classOf[DefaultServlet], "/")

    context.setAttribute(AsyncSupport.ExecutionContextKey, ExecutionContext.global)

    server.setHandler(context)

    server.start()
    server.join()
  }
}
