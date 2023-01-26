/**
 * Created by Jhon Solis on 04/10/22.
 **/
object ConfigGradle {
    object Release {
        const val versionCode = 3
        const val versionName = "1.2"
    }


    object BuildTypes{
        object Debug{
            const val keyAlias = "Pokedex"
            const val password = "fff"
            const val firmaFile= "debug.jks"
            const val firmaPassword = "Pokedex"
        }
        object Release{
            const val keyAlias = "Pokedex-Debug"
            const val password = "Pokedex821."
            const val firmaFile= "release.jks"
            const val firmaPassword = "Pokedex."
        }
    }


    object Module {
        const val data = ":data"
        const val componentes = ":componentes"
        const val domain = ":domain"

    }
}