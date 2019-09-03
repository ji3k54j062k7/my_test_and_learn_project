package com.example.test.base;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import com.example.test.R;
import com.example.test.utils.CommonUtils;
import com.example.test.utils.ToastCreator;

import java.util.Calendar;
import java.util.List;

public abstract class BaseFragment extends Fragment implements BaseView {
    private ProgressDialog mProgressDialog;
    private Calendar mCalendar = Calendar.getInstance();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void showProgressDialog(@StringRes int text) {
        dismissProgressDialog();
        mProgressDialog = new ProgressDialog(getActivity());
        mProgressDialog.setMessage(getActivity().getResources().getString(text));
        mProgressDialog.setCancelable(false);
        mProgressDialog.setCanceledOnTouchOutside(false);
        mProgressDialog.show();
    }

    @Override
    public void dismissProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.cancel();
        }
    }

    @Override
    public void showSelectDialog(@StringRes int text, DialogInterface.OnClickListener onClickListener) {
        new AlertDialog.Builder(getActivity())
                .setMessage(text)
                .setPositiveButton(R.string.hint_confirm, onClickListener)
                .setNegativeButton(R.string.hint_cancel, onClickListener)
                .setCancelable(false)
                .create()
                .show();
    }

    @Override
    public void showSelectDialog(String text, DialogInterface.OnClickListener onClickListener) {
        new AlertDialog.Builder(getActivity())
                .setMessage(text)
                .setPositiveButton(R.string.hint_confirm, onClickListener)
                .setNegativeButton(R.string.hint_cancel, onClickListener)
                .setCancelable(false)
                .create()
                .show();
    }
    @Override
    public void showItemDialog(List<String> list, DialogInterface.OnClickListener onClickListener) {
        new AlertDialog.Builder(getActivity())
                .setItems(list.toArray(new String[list.size()]), onClickListener)
                .create()
                .show();
    }

    @Override
    public void showDatePickerDialog(DatePickerDialog.OnDateSetListener onDateSetListener) {
        DatePickerDialog dialog = new DatePickerDialog(getActivity(),
                onDateSetListener,
                mCalendar.get(Calendar.YEAR),
                mCalendar.get(Calendar.MONTH),
                mCalendar.get(Calendar.DAY_OF_MONTH));
        dialog.show();
    }

    @Override
    public String getResourceString(@StringRes int text) {
        return getResources().getString(text);
    }

    @Override
    public String getResourceString(@StringRes int text, Object... args) {
        return CommonUtils.getStringResourceFormat(getActivity(), text, args);
    }

    @Override
    public void showToast(@StringRes int text) {
        ToastCreator.makeText(getActivity(), text, Toast.LENGTH_SHORT);
    }

    @Override
    public void showToast(String text) {
        ToastCreator.makeText(getActivity(), text, Toast.LENGTH_SHORT);
    }
}
