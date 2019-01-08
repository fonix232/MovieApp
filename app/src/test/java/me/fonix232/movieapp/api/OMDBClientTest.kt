package me.fonix232.movieapp.api

import kotlinx.coroutines.runBlocking
import me.fonix232.movieapp.networkModule
import me.fonix232.movieapp.omdbModule
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.koin.standalone.StandAloneContext.startKoin
import org.koin.standalone.inject
import org.koin.test.AutoCloseKoinTest

@RunWith(JUnit4::class)
class OMDBClientTest: AutoCloseKoinTest() {

    companion object {
        const val starwarsId: String = "tt0076759"
        const val starwarsSearch: String = "Star Wars"
        const val starwarsTitle: String = "Star Wars: Episode IV - A New Hope"
    }

    val client: IMovieClient by inject()

    @Before
    fun setUp() {
        startKoin(listOf(networkModule, omdbModule))
    }

    @Test
    fun searchTest() {
        val response = runBlocking { client.search(starwarsSearch) }
        assertTrue(response.size == 10)
    }

    @Test
    fun getTest() {
        val response = runBlocking { client.get(starwarsId) }

        assertEquals(response?.id, starwarsId)
        assertEquals(response?.title, starwarsTitle)
    }



}