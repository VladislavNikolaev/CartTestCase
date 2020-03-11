package by.tsetserskaya.carttestcase.utils

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.navigation.*

fun NavController.navigateSafe(
    @IdRes resId: Int,
    args: Bundle? = null,
    navOptions: NavOptions? = null,
    navExtras: Navigator.Extras? = null
) {
    val action = currentDestination?.getAction(resId)
    if (action != null) navigate(resId, args, navOptions, navExtras)
}