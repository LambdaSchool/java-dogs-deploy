package com.lambdaschool.dogsinitial

import com.lambdaschool.dogsinitial.Model.Dog

class DogList {

    val dogList : MutableList<Dog> = mutableListOf<Dog>()

    init {
        dogList.add(Dog("Springer", 50, false))
        dogList.add(Dog("Bulldog", 50, true))
        dogList.add(Dog("Collie", 50, false))
        dogList.add(Dog("Boston Terrie", 35, true))
        dogList.add(Dog("Corgie", 35, true))
    }

    fun findDog(tester: CheckDog): Dog? {
        for (d in dogList) {
            if (tester.test(d)) {
                return d
            }
        }
        return null
    }

    fun findDogs(tester: CheckDog): List<Dog> {
        val tempDogList = mutableListOf<Dog>()

        for (d in dogList) {
            if (tester.test(d)) {
                tempDogList.add(d)
            }
        }

        return tempDogList
    }
}