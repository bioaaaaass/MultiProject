package codegen

import com.typesafe.config.ConfigFactory

/**
  * Created by huangzhibo on 23/01/2017.
  */
object CodeGenerator extends App{
    val dbConf = ConfigFactory.load("db")

    val slickDriver = dbConf.getString("slick.driver")

    val jdbcDriver = dbConf.getString("jdbc.driver")

    val url = dbConf.getString("db.url")

    val outputFolder = dbConf.getString("output.folder")

    val pkg = dbConf.getString("pkg.name")

    val user = dbConf.getString("db.user.name")

    val password = dbConf.getString("db.user.password")

    slick.codegen.SourceCodeGenerator.main(Array(slickDriver, jdbcDriver, url, outputFolder, pkg, user, password))
}
