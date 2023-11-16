package com.zw.composetemplate.presentation.ui.exchange

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.zw.composetemplate.R
import com.zw.composetemplate.databinding.FragmentFilterBottomsheetBinding


class FilterBottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var mBinding: FragmentFilterBottomsheetBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentFilterBottomsheetBinding.inflate(inflater, container, false)

        return mBinding.root
    }


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialogFragment =
            BottomSheetDialog(requireContext(), R.style.MyTransparentBottomSheetDialogTheme)

        dialogFragment.setOnShowListener {
            val bottomSheet: FrameLayout? =
                dialogFragment.findViewById(com.google.android.material.R.id.design_bottom_sheet)

            val behavior: BottomSheetBehavior<FrameLayout>? =
                bottomSheet?.let { BottomSheetBehavior.from(it) }
            behavior?.skipCollapsed = true
            behavior?.state = BottomSheetBehavior.STATE_EXPANDED
        }

        return dialogFragment
    }


}