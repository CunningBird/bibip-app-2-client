package ru.iubip.catsapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import ru.iubip.catsapp.R
import ru.iubip.catsapp.data.client.CatsApi
import ru.iubip.catsapp.data.repository.FeaturedRepository
import ru.iubip.catsapp.data.repository.ListRepository
import ru.iubip.catsapp.data.repository.UploadRepository
import ru.iubip.catsapp.usecases.FeaturedUsecase
import ru.iubip.catsapp.usecases.ListUsecase
import ru.iubip.catsapp.usecases.UploadUsecase


class MainActivity : AppCompatActivity() {

    private val flex = Retrofit.Builder()
        .baseUrl("https://api.thecatapi.com/v1/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    private var client: CatsApi = flex.create(CatsApi::class.java)

    private val listRepository = ListRepository(client)
    private val featuredRepository = FeaturedRepository()
    private val uploadRepository = UploadRepository()

    val listUsecase = ListUsecase(listRepository)
    val featuredUsecase = FeaturedUsecase(featuredRepository)
    val uploadUsecase = UploadUsecase(uploadRepository)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        findViewById<BottomNavigationView>(R.id.bottom_nav).setupWithNavController(navController)
    }
}