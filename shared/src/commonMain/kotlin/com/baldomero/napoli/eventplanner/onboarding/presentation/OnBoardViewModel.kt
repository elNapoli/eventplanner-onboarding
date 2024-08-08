package com.baldomero.napoli.eventplanner.onboarding.presentation

import com.baldomero.napoli.eventplanner.core.PreferencesManager
import com.baldomero.napoli.eventplanner.core.presentation.viewModel.BaseViewModel
import com.baldomero.napoli.eventplanner.onboarding.presentation.OnboardContract.Effect
import com.baldomero.napoli.eventplanner.onboarding.presentation.OnboardContract.UiIntent
import com.baldomero.napoli.eventplanner.onboarding.presentation.OnboardContract.UiState
import com.rickclephas.kmp.observableviewmodel.launch

class OnBoardViewModel(
    private val preferences: PreferencesManager,

    ) : BaseViewModel<UiState, UiIntent, Effect>(
    UiState(preferences.getShownOnboarding())
) {
    private fun hideOnboarding() = scope.launch {
        preferences.setShownOnboarding()
        sendEffect(Effect.GoToAuthGraph)
    }


    override fun sendIntent(uiIntent: UiIntent) {
        when (uiIntent) {
            UiIntent.CompleteOnboarding -> hideOnboarding()
        }
    }

}