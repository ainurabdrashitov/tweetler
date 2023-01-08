package io.aabdrashitov.tweetler.configuration

import org.slf4j.LoggerFactory
import java.io.File
import java.util.*

class Config(
  localPropertiesLoader: () -> Properties = {
    Properties().apply {
      putAll(loadProperties("config"))
    }
  }
) {
  private val logger = LoggerFactory.getLogger(javaClass)
  private val props = HashMap<String, String>().apply {
    putAll(localPropertiesLoader().asMap)
    putAll(System.getProperties().asMap)
  }

  val isTest = (props["profile"] == "test").also { logger.info("Test profile mode = $it") }
  val dummyModeEnabled = props["profile"] == "dummy"

  operator fun get(key: String) = props[key] ?: throw RuntimeException("Missing config property $key")

  companion object {
    private val Properties.asMap get() = stringPropertyNames().associateWith { getProperty(it) }
    private fun loadProperties(fileName: String) = Properties().also { props ->
      File(Config::class.java.getResource("/conf/$fileName.properties")!!.toURI()).reader().use { props.load(it) }
    }
  }
}
