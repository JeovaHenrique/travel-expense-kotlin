package com.exemplo.travelexpense

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.exemplo.travelexpense.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

       mBinding.buttonCalculate.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val id: Int = view.id
        if (id == R.id.buttonCalculate) {
            calculate()
        }
    }

    private fun calculate() {
        if (isValidationOk()) {

            val distance = mBinding.editDistance.text.toString().toFloat()
            val price = mBinding.editPrice.text.toString().toFloat()
            val autonomy = mBinding.editAutonomy.text.toString().toFloat()

            val total = (distance * price) / autonomy

             mBinding.textResult.text = "R$ ${"%.2f".format(total)}"
        } else {
            Toast.makeText(this, getString(R.string.validation_fill_all_fields), Toast.LENGTH_SHORT).show()
        }
    }

    private fun isValidationOk(): Boolean = (
            mBinding.editDistance.text.toString() != "" &&
                    mBinding.editPrice.text.toString() != "" &&
                    mBinding.editAutonomy.text.toString() != "" &&
                    mBinding.editAutonomy.text.toString() != "0"
            )

}