package pl.modrakowski.receipes.home

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import pl.modrakowski.receipes.R
import pl.modrakowski.receipes.home.data.HomeData

class HomeActivity : AppCompatActivity(), HomeView {

    var presenter: HomePresenter = HomePresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()

        presenter.registerView(this)
        presenter.loadData()
    }

    override fun onPause() {
        presenter.unregisterView()

        super.onPause()
    }

    override fun onDataAvailable(data: HomeData) {
        runOnUiThread {
            Toast.makeText(this, "Data loaded!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDataError(error: Exception) {
        runOnUiThread {
            Toast.makeText(this, "Data loading error: ${error.message}", Toast.LENGTH_SHORT).show()
        }
    }
}
