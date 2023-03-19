package week3.taxipark

import kotlin.math.floor

/*
 * Task #1. Find all the drivers who performed no trips.
 */
fun TaxiPark.findFakeDrivers(): Set<Driver> =
    this.allDrivers.filter { driver ->
        !this.trips
            .map { trip -> trip.driver }
            .toSet()
            .contains(driver)
    }.toSet()

/*
 * Task #2. Find all the clients who completed at least the given number of trips.
 */
fun TaxiPark.findFaithfulPassengers(minTrips: Int): Set<Passenger> =
    this.allPassengers.filter { passenger ->
        this.trips
            .flatMap { it.passengers }
            .count { it == passenger } >= minTrips
    }.toSet()

/*
 * Task #3. Find all the passengers, who were taken by a given driver more than once.
 */
fun TaxiPark.findFrequentPassengers(driver: Driver): Set<Passenger> =
    this.allPassengers.filter { passenger ->
        this.trips
            .filter { it.driver.name == driver.name }
            .flatMap { it.passengers }
            .count { it == passenger } > 1
    }.toSet()

/*
 * Task #4. Find the passengers who had a discount for majority of their trips.
 */
fun TaxiPark.findSmartPassengers(): Set<Passenger> =
    this.allPassengers.filter { passenger ->
        val passengerTrips = this.trips.filter { it.passengers.contains(passenger) }
        (passengerTrips.count { (it.discount != null) && (it.discount > 0) }) > (passengerTrips.count() / 2)
    }.toSet()

/*
 * Task #5. Find the most frequent trip duration among minute periods 0..9, 10..19, 20..29, and so on.
 * Return any period if many are the most frequent, return `null` if there're no trips.
 */
fun TaxiPark.findTheMostFrequentTripDurationPeriod(): IntRange? {
    return this.trips.map { (it.duration - (it.duration % 10))..(it.duration + 9 - (it.duration % 10)) }
        .groupingBy { it }.eachCount().maxBy { it.value }?.key
}

/*
 * Task #6.
 * Check whether 20% of the drivers contribute 80% of the income.
 */
fun TaxiPark.checkParetoPrinciple(): Boolean {
    if (trips.isEmpty()) return false
    val revenue80Percent = this.trips.map { it.cost }.sum() * 0.8
    val drivers20Percent = floor(this.allDrivers.count() * 0.2).toInt()
    return this.allDrivers.asSequence().map { driver ->
        Pair(driver, this.trips.filter { it.driver.name == driver.name }.map { it.cost }.sum())
    }.sortedByDescending { it.second }.take(drivers20Percent).map { it.second }.sum() >= revenue80Percent
}