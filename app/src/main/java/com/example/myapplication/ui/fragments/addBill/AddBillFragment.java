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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class AddBillFragment extends BaseFragment implements AddBillContract.View {
    final DateFormat dateFormat_year = new SimpleDateFormat("yyyy");
    final DateFormat dateFormat_month = new SimpleDateFormat("MM");
    final DateFormat dateFormat_day = new SimpleDateFormat("dd");
    private String[] cycle = {"No", "Week", "Month", "Quater", "Year"};
    private EditText mETBillName;
    private EditText mETbillPrize;
    private String mDate;
    private Long mDateTime;
    private Button mButton;
    private Switch mSwitch;
    private Spinner mSpinner;
    private CheckBox mCheckBox;
    private CalendarView mCalendar;
    public String mBillStatus;
    private long mCycle;
    private static final long milWeek = 604800000L;
    private static final long milMonth = 2592000000L;
    private static final long milQuater = 3*milMonth;
    private static final long milYear = 12*milMonth;

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
        chceckIsCheckboxActive();
        setSpinnerSettings();
        setButtonAction();
        getDateFromCallendar();
    }

    private void setButtonAction() {
        mButton.setOnClickListener(v -> {
            if (mSwitch.isChecked()) {
                mBillStatus = "Bill Paid";
                Toast.makeText(getActivity(), "Bill Status : Paid",
                        Toast.LENGTH_LONG).show();
                addBill(mETBillName.getText().toString(), mBillStatus, Integer.parseInt(mETbillPrize.getText().toString()), mDate, String.valueOf(mCycle), mDateTime);
                startAllFragmentAfrerAdd();
            } else {
                mBillStatus = "Bill Unpaid";
                Toast.makeText(getActivity(), "Bill Status : UnPaid",
                        Toast.LENGTH_LONG).show();
                addBill(mETBillName.getText().toString(), mBillStatus, Integer.parseInt(mETbillPrize.getText().toString()),mDate, String.valueOf(mCycle), mDateTime);
                startAllFragmentAfrerAdd();
            }
        });
    }

    private void getDateFromCallendar() {
        mCalendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                month = month+1;
                mDate = String.valueOf(dayOfMonth + "-" + month + "-" + year);
                mDateTime = new Date(dayOfMonth,month,year).getTime();
            }
        });

    }

    private void setSpinnerSettings() {
        ArrayAdapter<String> mArrayAdapter = new ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, cycle);
        mArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(mArrayAdapter);
        mSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                if (parent.getItemAtPosition(position) == "No") {
                    mCycle = 0;
                } else if (parent.getItemAtPosition(position) == "Week") {
                    mCycle = milWeek;
                    Log.e("xd", "Select WeekItem");
                } else if (parent.getItemAtPosition(position) == "Month") {
                    mCycle = milMonth;
                    Log.e("xd", "Select MonthItem");
                } else if (parent.getItemAtPosition(position) == "Quater") {
                    mCycle = milQuater;
                    Log.e("xd", "Select QuaterItem");
                } else if (parent.getItemAtPosition(position) == "Year") {
                    mCycle = milYear;
                    Log.e("xd", "Select YearItem");
                }

                Log.v("item", (String) parent.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
    }

    private void chceckIsCheckboxActive() {
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
    }

    private void startAllFragmentAfrerAdd() {
        requireFragmentManager()
                .beginTransaction()
                .replace(R.id.nav_host_fragment, new AllBillsFragment())
                .addToBackStack(null)
                .commit();
    }

    private void initializeView() {
        mETBillName = getView().findViewById(R.id.addBillName);
        mETbillPrize = getView().findViewById(R.id.addBilPrize);
        mButton = getView().findViewById(R.id.saveButton);
        mSwitch = getView().findViewById(R.id.switchStatus);
        mSpinner = getView().findViewById(R.id.static_spinner);
        mCheckBox = getView().findViewById(R.id.checkBox);
        mCalendar = getView().findViewById(R.id.calendarView);
    }

    private void addBill(String billName, String billStatus, int billPrize, String billDate, String cycle, Long dateTime) {
        mPresenter.addNewBill(billName, billStatus, billPrize, billDate, cycle, dateTime);
        Log.e("xd", "cycle: " + cycle);
    }

}
