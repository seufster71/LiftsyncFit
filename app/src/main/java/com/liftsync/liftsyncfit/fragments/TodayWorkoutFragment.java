package com.liftsync.liftsyncfit.fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liftsync.liftsyncfit.MainActivity;
import com.liftsync.liftsyncfit.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TodayWorkoutFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TodayWorkoutFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TodayWorkoutFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TodayWorkoutFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TodayWorkoutFragment newInstance(String param1, String param2) {
        TodayWorkoutFragment fragment = new TodayWorkoutFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public TodayWorkoutFragment() {
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
        return inflater.inflate(R.layout.fragment_today_workout, container, false);
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
            case R.id.workout_today_button:
                //    TodayWorkoutFragment todayWorkoutFragment = TodayWorkoutFragment.newInstance("todayworkout","position1");
                //    fm.beginTransaction().replace(R.id.fragment_container, todayWorkoutFragment)
                //   .commit();
                break;
            case R.id.workout_clients_button:
                //     FragmentWorkoutMain fragmentClients = FragmentClients.newInstance("workout","position2");
                //     fm.beginTransaction().replace(R.id.fragment_container, fragmentWorkoutMain)
                //     .commit();
                break;
            case R.id.create_workout_button:
                //     FragmentWorkoutMain fragmentCreateWorkout = FragmentWorkoutMain.newInstance("workout","position2");
                //     fm.beginTransaction().replace(R.id.fragment_container, fragmentCreateWorkout)
                //             .commit();
                break;
        }
    }
}
