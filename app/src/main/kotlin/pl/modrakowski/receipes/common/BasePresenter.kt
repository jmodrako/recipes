package pl.modrakowski.receipes.common

import kotlin.jvm.internal.Intrinsics

abstract class BasePresenter<ViewType : BaseView<*>> {

    protected var view: ViewType? = null

    fun isViewAvailable() = view != null

    fun registerView(view: ViewType) {
        Intrinsics.checkParameterIsNotNull(view, "View must not be null!")

        this.view = view
    }

    fun unregisterView() {
        view = null
    }
}