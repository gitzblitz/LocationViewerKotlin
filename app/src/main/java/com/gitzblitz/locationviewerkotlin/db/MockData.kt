package com.gitzblitz.locationviewerkotlin.db

import com.gitzblitz.locationviewerkotlin.model.Location
import java.util.*
import java.util.concurrent.ThreadLocalRandom

class MockData {

    private val mockLocations = ArrayList<Location>()
    private val cities = arrayOf(
        "Cape Town",
        "Johannesburg",
        "Durban",
        "Port Elizabeth",
        "Nairobi",
        "Nakuru",
        "Copenhagen",
        "Seattle",
        "Los Angeles",
        "Boston",
        "Amsterdam",
        "Entebbe",
        "Windhoek",
        "Bangkok",
        "London",
        "Los Angeles",
        "New York",
        "Glasgow",
        "Shanghai"
    )


    fun generateLocations(): List<Location> {


        //        Random rand = new Random();


        //        int len = cities.length;
        for (i in 0..200) {

            mockLocations.add(getRandomLocation())
        }
        return mockLocations
    }

    private fun getRandomLocation(): Location {
        val rand = Random()
        val len = cities.size
        var randomInt: Int
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            randomInt = ThreadLocalRandom.current().nextInt(0, len)
        } else {
            randomInt = rand.nextInt(len)
        }
        val randCity = cities[randomInt]

        return Location(
            0,
            randCity,
            "Lorem ipsum some random location description", false,
            "GPS", "", "",
            String.format(Locale.getDefault(), "%.6f", rand.nextDouble()),
            String.format(Locale.getDefault(), "%.6f", rand.nextDouble()),
            null, ""
        )

    }

}