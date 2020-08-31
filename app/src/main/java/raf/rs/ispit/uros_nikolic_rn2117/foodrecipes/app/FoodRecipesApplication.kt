package raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.app

import android.app.Application
import com.facebook.stetho.Stetho
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.fragment.koin.fragmentFactory
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.module.categoryModule
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.module.coreModule
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.module.detailsModule
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.module.recipeModule
import timber.log.Timber

class FoodRecipesApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        init()
    }

    private fun init() {
        initTimber()
        initKoin()
        initStetho()
    }

    private fun initTimber() {
        Timber.plant(Timber.DebugTree())
    }

    private fun initKoin() {
        val modules = listOf(
            coreModule,
            categoryModule,
            recipeModule,
            detailsModule

        )
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@FoodRecipesApplication)
            androidFileProperties()
            fragmentFactory()
            modules(modules)
        }
    }

    private fun initStetho() {
        Stetho.initializeWithDefaults(this)
    }

}