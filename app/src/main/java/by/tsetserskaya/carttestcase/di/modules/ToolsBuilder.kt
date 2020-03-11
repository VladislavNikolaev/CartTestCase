package by.tsetserskaya.carttestcase.di.modules

import by.tsetserskaya.carttestcase.di.FragmentScoped
import by.tsetserskaya.carttestcase.ui.CartRecyclerItemFragment
import by.tsetserskaya.carttestcase.ui.ProductDetailFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class ToolsBuilder {

    @FragmentScoped
    @ContributesAndroidInjector
    internal abstract fun contributeCartRecyclerItemFragment(): CartRecyclerItemFragment

    @FragmentScoped
    @ContributesAndroidInjector
    internal abstract fun contributeProductDetailFragment(): ProductDetailFragment
}