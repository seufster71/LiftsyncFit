package com.liftsync.liftsyncfit.fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.liftsync.liftsyncfit.MainActivity;
import com.liftsync.liftsyncfit.R;
import com.liftsync.liftsyncfit.dialogs.GenderDialogFragment;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ProfileFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Button genderButton = null;
    private Button weightButton = null;
    private Button heightButton = null;
    private Button ageButton = null;
    private TextView bmrView = null;
    private Button username = null;
    private Button password = null;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        genderButton = (Button) view.findViewById(R.id.profile_gender_button);
        genderButton.setOnClickListener(this);

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    @Override
    public void onClick(View v) {
        MainActivity mainActivity = (MainActivity) getActivity();
        FragmentManager fm = mainActivity.getSupportFragmentManager();
        switch (v.getId()) {
            case R.id.profile_gender_button:
               // FuLogger.v(FuLogger.TRACE, TAG, "Gender Button");
                GenderDialogFragment gender = new GenderDialogFragment();
                gender.show(fm, "fragment_gender");
                break;
            case R.id.profile_weight_button:
              //  FuLogger.v(FuLogger.TRACE, TAG, "Weight Button");
              //  WeightDialogFragment weight = new WeightDialogFragment();
              //  weight.show(fm, "fragment_weight");
                break;
            case R.id.profile_height_button:
              //  FuLogger.v(FuLogger.TRACE, TAG, "Height Button");
              //  HeightDialogFragment v = new HeightDialogFragment();
              //  v.show(fm, "fragment_height");
                break;
            case R.id.profile_age_button:
             //   FuLogger.v(FuLogger.TRACE, TAG, "Age Button");
             //   AgeDialogFragment age = new AgeDialogFragment();
             //   age.show(fm, "fragment_age");
                break;
            case R.id.profile_username_button:
              //  FuLogger.v(FuLogger.TRACE, TAG, "Username Button");
              //  UsernameDialogFragment v = new UsernameDialogFragment();
              //  v.show(fm, "fragment_username");
                break;
            case R.id.profile_password_button:
               // FuLogger.v(FuLogger.TRACE, TAG, "Password Button");
              //  PasswordDialogFragment v = new PasswordDialogFragment();
             //   v.show(fm, "fragment_password");
                break;
        }
    }

    public void updateGender(String gender){
        genderButton.setText(gender);
    }

    public void updateWeight(Double value){
        weightButton.setText(value.toString());
    }

    public void updateHeight(Double value){
        heightButton.setText(value.toString());
    }

    public void updateAge(Integer value){
        ageButton.setText(value.toString());
    }

    public void updateUsername(String value){
        username.setText("Username\n" + value);
    }

    public void updatePassword(String value){
        password.setText("Password\nHint: " + value);
    }

    public void updateBMR(){
       // RunFuApp runFuApp = (RunFuApp) getActivity().getApplicationContext();
       // double bmr = GeneralHelper.bmr(runFuApp.getHeight(), runFuApp.getWeight(), runFuApp.getAge(), runFuApp.getGenderText(), "English");
       // bmrView.setText(String.format("%.2f", bmr));
    }
}
