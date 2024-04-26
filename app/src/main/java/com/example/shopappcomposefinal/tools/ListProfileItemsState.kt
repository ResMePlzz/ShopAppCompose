package com.example.shopappcomposefinal.tools

import com.example.shopappcomposefinal.R
import com.example.shopappcomposefinal.model.ProfileItemState
import com.example.shopappcomposefinal.presentation.viewmodels.ProfileScreenViewModel


class ListProfileItemsState(
    profileScreenViewModel: ProfileScreenViewModel,
) {


    val listProfileItemsState = listOf(
        ProfileItemState(
            icon = R.drawable.credit_card,
            text = "Trade store",
            iconEnd = R.drawable.arrow_vector
        ) { },
        ProfileItemState(
            icon = R.drawable.credit_card,
            text = "Payment method",
            iconEnd = R.drawable.arrow_vector
        ) {},
        ProfileItemState(icon = R.drawable.credit_card, text = "Balance", textEnd = "$ 1532") {},
        ProfileItemState(icon = R.drawable.credit_card, text = "Trade history") {},
        ProfileItemState(
            icon = R.drawable.group_92,
            text = "Restore Purchase",
            iconEnd = R.drawable.arrow_vector
        ) {},
        ProfileItemState(icon = R.drawable.group_91, text = "Help") {},
        ProfileItemState(
            icon = R.drawable.log_in,
            text = "Log out"
        ) {
            profileScreenViewModel.signOutToFB() {


            }
        }
    )
}

