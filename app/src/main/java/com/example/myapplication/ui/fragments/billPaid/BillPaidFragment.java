package com.example.myapplication.ui.fragments.billPaid;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.R;
import com.example.myapplication.ui.base.BaseFragment;

public class BillPaidFragment extends BaseFragment {

    @Override
    public @Nullable
    View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_bill_paid, container, false);
    }
}
