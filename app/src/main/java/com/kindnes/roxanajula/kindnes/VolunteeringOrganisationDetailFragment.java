package com.kindnes.roxanajula.kindnes;

import android.app.Activity;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toolbar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * A fragment representing a single VolunteeringOrganisation detail screen.
 * This fragment is either contained in a {@link VolunteeringOrganisationListActivity}
 * in two-pane mode (on tablets) or a {@link VolunteeringOrganisationDetailActivity}
 * on handsets.
 */
public class VolunteeringOrganisationDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";
    public Organisation mItem;
    Activity activity = this.getActivity();

    public VolunteeringOrganisationDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            //Get data from Firebase database
            DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference().child("organisations").child(getArguments().getString(ARG_ITEM_ID));
            rootRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot snapshot) {
                    mItem = snapshot.getValue(Organisation.class);
                }
                @Override
                public void onCancelled(DatabaseError firebaseError) {
                    System.out.println("The read failed: " + firebaseError.getMessage());
                }
            });
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.volunteeringorganisation_detail, container, false);

        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.volunteeringorganisation_detail)).setText(mItem.getDescription());
        }

        return rootView;
    }
}