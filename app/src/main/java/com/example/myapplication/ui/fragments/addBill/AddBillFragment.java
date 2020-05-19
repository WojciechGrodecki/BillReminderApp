package com.example.myapplication.ui.fragments.addBill;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.R;
import com.example.myapplication.ui.base.BaseFragment;
import com.example.myapplication.ui.fragments.allBills.AllBillsFragment;

import java.util.Objects;

public class AddBillFragment extends BaseFragment implements AddBillContract.View {
    private String[] cycle = {"Week", "Month", "Quater", "Year"};
    private EditText mETBillName;
    private EditText mETbillPrize;
    private Button mButton;
    private Switch mSwitch;
    private Spinner mSpinner;
    private CheckBox mCheckBox;
    private CalendarView mCalendar;
    public String mBillStatus;

    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private AddBillContract.Presenter mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_add_bill, container, false);

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter = new AddBillPresenter(this);
        initializeView();
        mSpinner.setVisibility(View.INVISIBLE);
        mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    mSpinner.setVisibility(View.VISIBLE);
                } else {
                    mSpinner.setVisibility(View.INVISIBLE);
                }

            }
        });

        ArrayAdapter<String> mArrayAdapter = new ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, cycle);
        mArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(mArrayAdapter);
        mSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                if (parent.getItemAtPosition(position) == "Week") {
                    Log.e("xd", "Select WeekItem");
                } else if (parent.getItemAtPosition(position) == "Month") {
                    Log.e("xd", "Select MonthItem");
                } else if (parent.getItemAtPosition(position) == "Quater") {
                    Log.e("xd", "Select QuaterItem");
                } else if (parent.getItemAtPosition(position) == "Year") {
                    Log.e("xd", "Select YearItem");
                }

                Log.v("item", (String) parent.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });


        mButton.setOnClickListener(v -> {
            if (mSwitch.isChecked()) {
                mBillStatus = "Bill Paid";
                Toast.makeText(getActivity(), "Bill Status : Paid",
                        Toast.LENGTH_LONG).show();
                addBill(mETBillName.getText().toString(), mBillStatus, Integer.parseInt(mETbillPrize.getText().toString()));
                startAllFragmentAfrerAdd();
            } else {
                mBillStatus = "Bill Unpaid";
                Toast.makeText(getActivity(), "Bill Status : UnPaid",
                        Toast.LENGTH_LONG).show();
                addBill(mETBillName.getText().toString(), mBillStatus, Integer.parseInt(mETbillPrize.getText().toString()));
                startAllFragmentAfrerAdd();
            }
        });
    }

    private void chceckIsCheckboxActive() {

    }

    private void startAllFragmentAfrerAdd() {
        requireFragmentManager()
                .beginTransaction()
                .replace(R.id.flContainer, new AllBillsFragment())
                .addToBackStack(null)
                .commit();
    }

    private void initializeView() {
        mETBillName = Objects.requireNonNull(getView()).findViewById(R.id.addBillName);
        mETbillPrize = getView().findViewById(R.id.addBilPrize);
        mButton = getView().findViewById(R.id.saveButton);
        mSwitch = getView().findViewById(R.id.switchStatus);
        mSpinner = getView().findViewById(R.id.static_spinner);
        mCheckBox = getView().findViewById(R.id.checkBox);
        mCalendar = getView().findViewById(R.id.calendarView);
    }

    private void addBill(String billName, String billStatus, int BillPrize) {
        mPresenter.addNewBill(billName, billStatus, BillPrize);
    }


}
