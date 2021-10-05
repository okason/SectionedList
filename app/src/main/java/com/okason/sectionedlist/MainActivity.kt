package com.okason.sectionedlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.io.InputStream

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fetchAndPrintProducts()
    }

    private fun fetchAndPrintProducts() {
        val inputStream: InputStream = resources.openRawResource(R.raw.mock_products)
        val csvParser = CSVParser(inputStream)
        val productList = csvParser.read()
       productList.forEach { product: Products ->
            Log.i("MainActivity", product.toString())
        }
    }
}