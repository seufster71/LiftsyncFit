package com.liftsync.liftsyncfit.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

import com.liftsync.liftsyncfit.MainActivity;
import com.liftsync.liftsyncfit.R;

/**
 * Created by seufster on 11/18/15.
 */
public class GenderDialogFragment extends DialogFragment {
    final CharSequence myList[] = { "Female", "Male"};
    public static final String TAG = "GenderDialog";
    private int mSelectedItem = 0;
    private boolean changed = false;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);
        //int genderDefault = ((RunFuApp) getActivity().getApplicationContext()).getGender();
        int genderDefault = 0;
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

      /*  if (t != null && t.isTimerRunning()){
            builder.setTitle("Can not change Gender during run event!")
                    .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {
                            // User clicked OK, so save the mSelectedItems results somewhere
                            // or return them to the component that opened the dialog
                        }
                    });
            return builder.create();
        }*/
        builder.setTitle("Gender")
                .setSingleChoiceItems(myList, genderDefault,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                mSelectedItem = which;
                                changed = true;

                            }
                        })
                        // Set the action buttons
                .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        //FuLogger.v(FuLogger.TRACE, TAG, "onclick dialog " + id);
                        if (changed) {
                           // ((MainActivity) getActivity()).setGender(mSelectedItem);
                        }
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }
}
