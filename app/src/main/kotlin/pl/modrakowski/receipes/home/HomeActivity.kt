package pl.modrakowski.receipes.home

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.TypedValue
import android.view.Gravity
import android.widget.FrameLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import pl.modrakowski.receipes.R
import pl.modrakowski.receipes.common.data.Recipe
import pl.modrakowski.receipes.home.data.HomeData

class HomeActivity : AppCompatActivity(), HomeView, HomeAdapter.OnHomeItemClickListener {

    var presenter: HomePresenter = HomePresenter()
    val adapter: HomeAdapter = HomeAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter.onHomeItemClickListener = this

        home_list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        home_list.adapter = adapter

        setupToolbar()
        setupNavigationBarBackground()
    }

    private fun setupNavigationBarBackground() {
        val navigationBarHeight = navigationBarHeight();
        val lp: FrameLayout.LayoutParams = FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT, navigationBarHeight)
        lp.gravity = Gravity.BOTTOM
        home_navigation_background.layoutParams = lp
    }

    private fun navigationBarHeight(): Int {
        var result: Int = 0
        val resourceId: Int = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = resources.getDimensionPixelSize(resourceId);
        }
        return result
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

    override fun onHomeItemClick(recipe: Recipe) {
        Toast.makeText(this, recipe.toString(), Toast.LENGTH_SHORT).show()
    }

    override fun onDataAvailable(data: HomeData) {
        runOnUiThread {
            adapter.updateData(data.recipes)
            adapter.notifyDataSetChanged()
        }
    }

    override fun onDataError(error: Exception) {
        runOnUiThread {
            Snackbar.make(home_container, "Can't load data.", Snackbar.LENGTH_LONG)
                    .setAction("Retry", { presenter.loadData() }).show();
        }
    }

    private fun setupToolbar() {
        val paddingTop: Int = getStatusBarHeight()
        toolbar.setPadding(toolbar.paddingLeft, paddingTop,
                toolbar.paddingRight, toolbar.paddingBottom)

        setSupportActionBar(toolbar)

        val tv = TypedValue()

        if (theme.resolveAttribute(R.attr.actionBarSize, tv, true)) {
            val actionBarHeight = TypedValue.complexToDimensionPixelSize(
                    tv.data, resources.displayMetrics)

            home_list.setPadding(home_list.paddingLeft, paddingTop + actionBarHeight,
                    home_list.paddingRight, navigationBarHeight())
        }
    }

    fun getStatusBarHeight(): Int {
        var result = 0
        val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
        if (resourceId > 0) {
            result = resources.getDimensionPixelSize(resourceId)
        }
        return result
    }
}
