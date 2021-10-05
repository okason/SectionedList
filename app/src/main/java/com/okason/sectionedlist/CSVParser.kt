package com.okason.sectionedlist

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader

class CSVParser(val inputStream: InputStream) {
    fun read(): List<Products> {
        val result = mutableListOf<Products>()
        val reader = BufferedReader(InputStreamReader(inputStream))
        try {
            var csvLine: String
            while (reader.readLine() != null){
                csvLine = reader.readLine()
                val row = csvLine.split(",".toRegex()).toTypedArray()
                val id: Int = row[0].toInt()
                val name: String = row[1]
                val price: Double = row[2].toDouble()
                val description: String = row[3]
                val product = Products(id, name, price, description)
                result.add(product)
            }
        } catch (ex: IOException) {
            throw RuntimeException("Error in reading CSV file: $ex");
        } finally {
            try {
                inputStream.close()
            } catch (e: IOException) {
                throw RuntimeException("Error while closing input stream: $e");
            }
        }
        return result
    }
}