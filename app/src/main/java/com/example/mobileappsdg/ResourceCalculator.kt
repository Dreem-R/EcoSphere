package com.example.mobileappsdg

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import com.google.android.material.card.MaterialCardView
import com.google.android.material.textfield.TextInputLayout
import net.objecthunter.exp4j.ExpressionBuilder

class ResourceCalculator : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resource_calculator)

        // Get references to UI elements
        val spinnerElectricityUsage = findViewById<Spinner>(R.id.spinnerElectricityUsage)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val tvResult = findViewById<TextView>(R.id.tvResult)
        val tvFeedback = findViewById<TextView>(R.id.tvFeedback)
        val resultContainer = findViewById<MaterialCardView>(R.id.resultContainer)

        // Set up Spinner
        val electricityOptions = arrayOf("Low (100-200 kWh)", "Average (200-400 kWh)", "High (400+ kWh)")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, electricityOptions)
        spinnerElectricityUsage.adapter = adapter

        btnCalculate.setOnClickListener {
            val selectedElectricityUsage = spinnerElectricityUsage.selectedItem.toString()

            val kilometersDrivenValue = findViewById<TextInputLayout>(R.id.tilMilesDriven).editText?.text.toString()
            val flightsPerYear = findViewById<TextInputLayout>(R.id.tilFlightsPerYear).editText?.text.toString()
            val meatConsumption = findViewById<TextInputLayout>(R.id.tilMeatConsumption).editText?.text.toString()
            val dairyConsumption = findViewById<TextInputLayout>(R.id.Dairycon).editText?.text.toString()
            val beverageConsumption = findViewById<TextInputLayout>(R.id.Bevcon).editText?.text.toString()
            val clothesSpending = findViewById<TextInputLayout>(R.id.tilClothesSpending).editText?.text.toString()

            // Calculate carbon footprint
            val (footprint, highestData) = calculateCarbonFootprint(
                kilometersDrivenValue, flightsPerYear, selectedElectricityUsage,
                meatConsumption, dairyConsumption, beverageConsumption, clothesSpending
            )

            // Get the highest contributor and its carbon value
            val highestContributor = highestData.first
            val highestCarbon = highestData.second

            // Display results
            resultContainer.visibility = View.VISIBLE
            tvResult.visibility = View.VISIBLE
            tvFeedback.visibility = View.VISIBLE
            tvResult.text = "Your estimated carbon footprint is: ${String.format("%.2f", footprint)} tonnes CO2e"

            // Provide feedback and tips
            val feedback = when {
                footprint < 5 -> "Excellent! You have a very low carbon footprint. Keep up the great work!"
                footprint in 5.0..10.0 -> "Good job! You're doing better than average. Consider making some small changes to reduce your impact further."
                footprint in 10.0..15.0 -> "Your carbon footprint is around average. There's room for improvement. Explore ways to reduce your emissions."
                else -> "Your carbon footprint is quite high. It's time to make significant changes to your lifestyle to reduce your impact on the environment."
            }

            val additionalFeedback = "The category contributing the most to your carbon footprint is: $highestContributor with $highestCarbon tonnes CO2e."

            tvFeedback.text = "$feedback\n\n$additionalFeedback"

            // Apply window insets to the ScrollView
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.scrollView)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }
    }

    fun evaluateExpression(expression: String): Double? {
        return try {
            val result = ExpressionBuilder(expression).build().evaluate()
            result
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    // Function to calculate carbon footprint based on user inputs
    private fun calculateCarbonFootprint(
        milesDriven: String,
        flightsPerYear: String,
        electricityUsage: String,
        meatConsumption: String,
        dairyConsumption: String,
        beverageConsumption: String,
        clothesSpending: String
    ): Pair<Double, Pair<String, Double>> {
        var footprint = 0.0
        var highestContributor = ""
        var highestCarbon = 0.0

        // Evaluate expressions or default to 0
        val kilometersDrivenValue = evaluateExpression(milesDriven) ?: 0.0
        val flightsValue = evaluateExpression(flightsPerYear)?.toInt() ?: 0

        val electricityValue = when (electricityUsage) {
            "Low (100-200 kWh)" -> 150.0
            "Average (200-400 kWh)" -> 300.0
            "High (400+ kWh)" -> 450.0
            else -> 0.0
        }

        val meatValue = evaluateExpression(meatConsumption)?.toInt() ?: 0
        val dairyValue = evaluateExpression(dairyConsumption) ?: 0.0
        val beverageValue = evaluateExpression(beverageConsumption)?.toInt() ?: 0
        val clothesValue = evaluateExpression(clothesSpending) ?: 0.0

        // Calculate carbon footprint and track the highest contributor
        val kilometersCarbon = kilometersDrivenValue * 0.251
        if (kilometersCarbon > highestCarbon) {
            highestCarbon = kilometersCarbon
            highestContributor = "Kilometers Driven"
        }
        footprint += kilometersCarbon

        val flightsCarbon = flightsValue * 0.254
        if (flightsCarbon > highestCarbon) {
            highestCarbon = flightsCarbon
            highestContributor = "Flights per Year"
        }
        footprint += flightsCarbon

        val electricityCarbon = electricityValue * 0.00053
        if (electricityCarbon > highestCarbon) {
            highestCarbon = electricityCarbon
            highestContributor = "Electricity Usage"
        }
        footprint += electricityCarbon

        val meatCarbon = meatValue * 0.025
        if (meatCarbon > highestCarbon) {
            highestCarbon = meatCarbon
            highestContributor = "Meat Consumption"
        }
        footprint += meatCarbon

        val dairyCarbon = dairyValue * 0.065
        if (dairyCarbon > highestCarbon) {
            highestCarbon = dairyCarbon
            highestContributor = "Dairy Consumption"
        }
        footprint += dairyCarbon

        val beverageCarbon = beverageValue * 0.05
        if (beverageCarbon > highestCarbon) {
            highestCarbon = beverageCarbon
            highestContributor = "Beverage Consumption"
        }
        footprint += beverageCarbon

        val clothesCarbon = (clothesValue / 84) * 0.005
        if (clothesCarbon > highestCarbon) {
            highestCarbon = clothesCarbon
            highestContributor = "Clothes Spending"
        }
        footprint += clothesCarbon

        return Pair(footprint, Pair(highestContributor, highestCarbon))
    }
}