// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/ege/Desktop/SSSAMC/MCDEV/BackEnd/conf/routes
// @DATE:Mon Nov 05 22:47:42 IST 2018


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
