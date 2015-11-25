package com.liftsync.liftsyncfit.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.liftsync.liftsyncfit.R;


/**
 * Created by seufster on 1/27/15.
 */
public class MuscleGroupDialogFragment extends DialogFragment {
    final CharSequence myList[] = { "Arms", "Core" , "Legs"};
    public static final String TAG = "MuscleGroupDialog";
    private int mSelectedItem = 0;
    private boolean changed = false;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);
        int genderDefault = 0;
        LayoutInflater li = LayoutInflater.from(getActivity());
        View view = li.inflate(R.layout.muscle_group_dialog, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

         /*   builder.setTitle("Can not change Password during run event!")
                    .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {
                            // User clicked OK, so save the mSelectedItems results somewhere
                            // or return them to the component that opened the dialog
                        }
                    });
            return builder.create();*/


        final EditText customMuscleGroup = (EditText) view.findViewById(R.id.custom_muscle_group);

        builder.setTitle("Password")
                .setSingleChoiceItems(myList, genderDefault,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mSelectedItem = which;
                                changed = true;

                            }
                        })
                        // Set the action buttons
                .setView(view)
                .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        //FuLogger.v(FuLogger.TRACE, TAG, "onclick dialog " + id);

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
