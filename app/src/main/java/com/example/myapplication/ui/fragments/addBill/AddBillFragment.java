package com.example.myapplication.ui.fragments.addBill;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.R;
import com.example.myapplication.ui.base.BaseFragment;
import com.example.myapplication.ui.fragments.allBills.AllBillsPresenter;

import java.util.Objects;

public class AddBillFragment extends BaseFragment implements AddBillContract.View {
    private EditText mETBillName;
    private EditText mETbillPrize;
    private Button mButton;
    private Switch mSwitch;
    public String mBillStatus;

    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private AddBillContract.Presenter mPresenter;

    @Override
    public @Nullable
    View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_bill, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter = new AddBillPresenter(this);

        initializeView();
        mButton.setOnClickListener(v -> {
            if (mSwitch.isChecked()) {
                mBillStatus = "Bill Paid";
                Toast.makeText(getActivity(), "Bill Status : Paid",
                        Toast.LENGTH_LONG).show();
                addBill(mETBillName.getText().toString(),mBillStatus,Integer.parseInt(mETbillPrize.getText().toString()));
            } else {
                mBillStatus = "Bill Unpaid";
                addBill(mETBillName.getText().toString(),mBillStatus,Integer.parseInt(mETbillPrize.getText().toString()));
            }
        });
    }

    private void initializeView() {
        mETBillName = Objects.requireNonNull(getView()).findViewById(R.id.addBillName);
        mETbillPrize = getView().findViewById(R.id.addBilPrize);
        mButton = getView().findViewById(R.id.saveButton);
        mSwitch = getView().findViewById(R.id.switchStatus);
    }

    private void addBill(String billName, String billStatus, int BillPrize) {
        mPresenter.addNewBill(billName,billStatus,BillPrize);
    }

}
