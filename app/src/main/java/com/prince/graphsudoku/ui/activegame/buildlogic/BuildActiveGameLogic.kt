package com.prince.graphsudoku.ui.activegame

import android.content.Context
import com.prince.graphsudoku.ui.activegame.ActiveGameContainer
import com.prince.graphsudoku.ui.activegame.ActiveGameLogic
import com.prince.graphsudoku.ui.activegame.ActiveGameViewModel
import com.prince.graphsudoku.common.ProductionDispatcherProvider
import com.prince.graphsudoku.persistence.*


internal fun buildActiveGameLogic(
    container: ActiveGameContainer,
    viewModel: ActiveGameViewModel,
    context: Context
): ActiveGameLogic {
    return ActiveGameLogic(
        container,
        viewModel,
        GameRepositoryImpl(
            LocalGameStorageImpl(context.filesDir.path),
            LocalSettingsStorageImpl(context.settingsDataStore)
        ),
        LocalStatisticsStorageImpl(
            context.statsDataStore
        ),
        ProductionDispatcherProvider
    )
}