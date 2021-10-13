package com.prince.graphsudoku.ui.newgame.buildlogic

import android.content.Context
import com.prince.graphsudoku.common.ProductionDispatcherProvider
import com.prince.graphsudoku.persistence.*
import com.prince.graphsudoku.ui.newgame.NewGameContainer
import com.prince.graphsudoku.ui.newgame.NewGameLogic
import com.prince.graphsudoku.ui.newgame.NewGameViewModel

internal fun buildNewGameLogic(
    container: NewGameContainer,
    viewModel: NewGameViewModel,
    context: Context
): NewGameLogic {
    return NewGameLogic(
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