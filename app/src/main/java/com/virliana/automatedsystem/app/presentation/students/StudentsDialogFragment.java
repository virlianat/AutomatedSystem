package com.virliana.automatedsystem.app.presentation.students;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.virliana.automatedsystem.R;

public class StudentsDialogFragment extends DialogFragment {

    EditText nfsEditText;
    EditText dateOfBirthEditText;
    EditText emailEditText;
    EditText phoneEditText;
    StudentsDialogListener listener;

    @TargetApi(Build.VERSION_CODES.O)
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.dialog_add_student, null);
        nfsEditText = (EditText) view.findViewById(R.id.et_nfs);
        dateOfBirthEditText = (EditText) view.findViewById(R.id.et_date_of_birth);
        emailEditText = (EditText) view.findViewById(R.id.et_email);
        phoneEditText = (EditText) view.findViewById(R.id.et_phone_number);
        builder.setView(view).setTitle("Додати учня").setNegativeButton("Скасувати", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        }).setPositiveButton("Додати", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String nfs = nfsEditText.getText().toString();
                String dateOfBirth = dateOfBirthEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String phone = phoneEditText.getText().toString();
                listener.createStudent(nfs, dateOfBirth, email, phone);
            }
        });
        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (StudentsDialogListener) getTargetFragment();
        } catch (ClassCastException c) {
            throw new ClassCastException(context.toString() + "must implement dialog listener");
        }
    }

    public interface StudentsDialogListener {
        void createStudent(String nfs, String dateOfBirth, String email, String phone);

    }
}
