// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/ege/Desktop/SSSAMC/MCDEV/BackEnd/conf/routes
// @DATE:Sat Nov 03 21:02:20 IST 2018


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
